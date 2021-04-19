package com.kevinleader.bgr.analyzer;

import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.persistence.SteamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Ranker {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private SteamDao steamDao = new SteamDao();
    private int steamId;
    private List<Integer> prices;

    public Ranker() {
        prices = new ArrayList<>();
    }

    public List<Integer> getPrices(Game[] games) throws Exception {
        for (Game game : games) {
            if (game.getPlatforms().contains(34) ||
                    game.getPlatforms().contains(39)) { //check if on mobile (freemium)
                prices.add(0);
            } else if (game.getPlatforms().contains(3)) { //check if on PC
                steamId = steamDao.findSteamIdFromName(game.getName());
                if (steamId <= 0) {
                    prices.add(-2); //unknown price
                } else { //TODO: Create class/method for steam info
                    prices.add(-1); //steam price maybe
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
                prices.add(-2); //unknown price
            }
        }
        return prices;
    }

    public List<Integer> getPrices(Game[] games) throws Exception {

    }

}
