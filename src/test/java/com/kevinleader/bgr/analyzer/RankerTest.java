package com.kevinleader.bgr.analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.persistence.IgdbDao;
import com.kevinleader.bgr.persistence.SteamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RankerTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Ranker ranker;
    IgdbDao igdbDao;
    SteamDao steamDao;

    @Test
    public void getPricesSuccess() throws Exception {
        ranker = new Ranker();
        igdbDao = new IgdbDao();
        String whereConditions = " & first_release_date > " +
                igdbDao.getReleaseDateEpoch(157784630);
        List<Integer> prices;
        Game[] games = igdbDao.loadGamesToRank(whereConditions);
        prices = ranker.getPrices(games);
        assertEquals(games.length, prices.size());

    }

    @Test // TODO: Make work
    public void getGameValuesSuccess() throws Exception {
        ranker = new Ranker();
        igdbDao = new IgdbDao();
        Game[] games = igdbDao.searchFromGameName("Hades");
        List<Integer> prices = ranker.getPrices(games);
        List<Double> values = ranker.getGameValues(games, prices);
        assertEquals("??", values);
    }

}
