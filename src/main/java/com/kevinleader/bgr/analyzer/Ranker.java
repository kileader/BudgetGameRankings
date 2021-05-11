package com.kevinleader.bgr.analyzer;

import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.igdb.Website;
import com.kevinleader.bgr.entity.ranker.RankedGame;
import com.kevinleader.bgr.entity.steam.PriceOverview;
import com.kevinleader.bgr.persistence.IgdbDao;
import com.kevinleader.bgr.persistence.SteamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains logic for the ranking of games by value.
 *
 * @author Kevin Leader
 */
public class Ranker {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final SteamDao steamDao;
    private final IgdbDao igdbDao;

    /**
     * Instantiates a new Ranker.
     */
    public Ranker() {
        steamDao = new SteamDao();
        igdbDao = new IgdbDao();
    }

    /**
     * Gets game prices in US Cents from steam or estimates them according to game platform.
     *
     * @param games the games
     * @return the prices
     * @throws Exception the exception
     */
    public List<Integer> getPrices(Game[] games) throws Exception {
        List<Integer> steamIds = new ArrayList<>();
        List<Integer> steamPrices = new ArrayList<>();
        List<Integer> otherPrices = new ArrayList<>();
        List<Boolean> indexIsSteamPrice = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();

        for (Game game : games) {
            logger.debug("find price for {}", game.getName());

            int price = -1; //unknown price
            boolean isSteamPrice = false;

            if (game.getPlatforms().contains(48) ||
                    game.getPlatforms().contains(49) ||
                    game.getPlatforms().contains(130) ||
                    game.getPlatforms().contains(165)) { //check if $60 game (eighth gen)
                price = 5999;
                logger.debug("assign price as 5999");
            } else if (game.getPlatforms().contains(167) ||
                    game.getPlatforms().contains(169)) { //check if $70 game (ninth gen)
                price = 6999;
                logger.debug("assign price as 6999");
            }
            if (game.getPlatforms().contains(34) ||
                    game.getPlatforms().contains(39)) { //check if on mobile (freemium)
                price = 0;
                logger.debug("assign price as freemium");
            }


            if (game.getPlatforms().contains(6) ||
                    game.getPlatforms().contains(162) ||
                    game.getPlatforms().contains(163)) { //check if on PC or VR
                int steamId = -1;
                List<Website> websites = game.getWebsites();
                if (websites != null) {
                    for (Website website : websites) { //check for steam url to get steamId
                        if (website.getCategory() == 13) { //if the url is for steam
                            String steamUrl = website.getUrl();
                            Pattern pattern = Pattern.compile("app\\/\\d+");
                            Matcher matcher = pattern.matcher(steamUrl);
                            if (matcher.find()) {
                                String stringGroup = matcher.group();
                                String stringId = stringGroup.substring(4);
                                steamId = Integer.parseInt(stringId); //extract the id
                            }
                            break;
                        }
                    }
                }
                if (steamId > 0) { //if steamId exists
                    steamIds.add(steamId);
                    isSteamPrice = true;
                    logger.debug("steam price");
                }
            }
            if (!isSteamPrice) {
                otherPrices.add(price);
            }
            indexIsSteamPrice.add(isSteamPrice);
        }

        List<PriceOverview> priceOverviews = steamDao.getPriceOverviewsFromIds(steamIds);
        for (PriceOverview po : priceOverviews) {
            int price;
            if (po != null) {
                price = po.getJsonMemberFinal(); //get the steam final price
                logger.debug("assign price as {}", price);
            } else {
                price = -1; //it's unknown
                logger.debug("assign price as unknown");
            }
            steamPrices.add(price);
        }

        int steamIndex = 0;
        int otherIndex = 0;
        for (boolean isSteamPrice : indexIsSteamPrice) {
            if (isSteamPrice) {
                prices.add(steamPrices.get(steamIndex));
                steamIndex++;
            } else {
                prices.add(otherPrices.get(otherIndex));
                otherIndex++;
            }
        }
        return prices;
    }

    /**
     * Calculates game value by dividing total rating on IGDB.com by the game price in USD.
     *
     * @param games  the games
     * @param prices the prices
     * @return the game values
     * @throws Exception the exception
     */
    public List<Double> getGameValues(Game[] games, List<Integer> prices) throws Exception {
        List<Double> values = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            if (prices.get(i) <= 0) {
                values.add(-1.0);
            } else {
                values.add(games[i].getTotalRating()/((double) prices.get(i)/100));
            }
        }
        return values;
    }

    /**
     * Aggregates data for listing the ranked games.
     *
     * @param games the games
     * @return the ranked game list
     * @throws Exception the exception
     */
    public List<RankedGame> getRankedGameList(Game[] games) throws Exception {
        List<String> names = igdbDao.getNames(games);
        List<Integer> prices = getPrices(games);
        List<Double> values = getGameValues(games, prices);

        List<RankedGame> rankedGames = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            RankedGame rankedGame = new RankedGame(names.get(i), values.get(i),
                    games[i].getRating(), (double) prices.get(i)/100,
                    games[i].getUrl(), games[i].getWebsites(), games[i].getId());
            rankedGames.add(rankedGame);
        }
        return rankedGames;
    }

}
