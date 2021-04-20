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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Ranker.
 */
public class Ranker {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final SteamDao steamDao;

    /**
     * Instantiates a new Ranker.
     */
    public Ranker() {
        steamDao = new SteamDao();
    }

    /**
     * Gets prices.
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

            if (game.getPlatforms().contains(41) ||
                    game.getPlatforms().contains(48) ||
                    game.getPlatforms().contains(49) ||
                    game.getPlatforms().contains(130) ||
                    game.getPlatforms().contains(165)) { //check if $60 game (last gen)
                price = 5999;
                logger.debug("assign price as 5999");
            } else if (game.getPlatforms().contains(167) ||
                    game.getPlatforms().contains(169)) { //check if $70 game (current gen)
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
                price = 0; //it's free or freemium
                logger.debug("assign price as free(mium)");
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
     * Gets game values.
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
                values.add(games[i].getTotalRating()/(prices.get(i)/100));
            }
        }
        return values;
    }

    /**
     * Gets ranked game list.
     *
     * @param names  the names
     * @param values the values
     * @return the ranked game list
     */
    public List<RankedGame> getRankedGameList(List<String> names, List<Double> values) {
        List<RankedGame> rankedGames = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            RankedGame rankedGame = new RankedGame(names.get(i), values.get(i));
            rankedGames.add(rankedGame);
        }
        return rankedGames;
    }

}
