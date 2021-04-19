package com.kevinleader.bgr.analyzer;

import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.steam.PriceOverview;
import com.kevinleader.bgr.persistence.SteamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Ranker {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private SteamDao steamDao;
    private List<Integer> prices;

    public Ranker() {
        steamDao = new SteamDao();
        prices = new ArrayList<>();
    }

    public List<Integer> getPrices(Game[] games) throws Exception {
        for (Game game : games) {
            if (game.getPlatforms().contains(34) ||
                    game.getPlatforms().contains(39)) { //check if on mobile (freemium)
                prices.add(0);
            } else if (game.getPlatforms().contains(3)) { //check if on PC
                int steamId = steamDao.findSteamIdFromName(game.getName());
                if (steamId <= 0) { //if steamId doesn't exist
                    prices.add(-1); //unknown price
                } else if (steamId > 0) { //if steamId exists
                    PriceOverview priceOverview = steamDao.getPriceOverviewFromId(steamId);
                    if (priceOverview != null) {
                        prices.add(priceOverview.getJsonMemberFinal()); //get the steam final price
                    } else {
                        prices.add(0); //it's free or freemium
                    }
                }
            } else if (game.getPlatforms().contains(41) ||
                    game.getPlatforms().contains(48) ||
                    game.getPlatforms().contains(49) ||
                    game.getPlatforms().contains(130)) { //check if $60 game (last gen)
                prices.add(5999);
            } else if (game.getPlatforms().contains(167) ||
                    game.getPlatforms().contains(169)) { //check if $70 game (current gen)
                prices.add(6999);
            } else {
                prices.add(-1); //unknown price
            }
        }
        return prices;
    }

    public List<Double> getGameValues(Game[] games, List<Integer> prices) throws Exception {
        List<Double> values = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            if (prices.get(i) <= 0) {
                values.add(-1.0);
            } else {
                values.add(games[i].getTotalRating()/prices.get(i));
            }
        }
        return values;
    }

}
