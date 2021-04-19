package com.kevinleader.bgr.analyzer;

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
        String whereConditions = "";
        List<Integer> prices;
        Game[] games = igdbDao.loadGamesToRank(whereConditions);
        prices = ranker.getPrices(games);
        assertEquals(games.length, prices.size());
    }

}
