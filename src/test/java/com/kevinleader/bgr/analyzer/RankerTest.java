package com.kevinleader.bgr.analyzer;

import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.ranker.RankedGame;
import com.kevinleader.bgr.persistence.IgdbDao;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Ranker class.
 */
public class RankerTest {

    /**
     * The Ranker.
     */
    Ranker ranker;
    /**
     * The Igdb dao.
     */
    IgdbDao igdbDao;

    /**
     * Tests getting prices.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPricesSuccess() throws Exception {
        ranker = new Ranker();
        igdbDao = new IgdbDao();
        String whereConditions = "where first_release_date > " +
                igdbDao.getReleaseDateEpoch(157784630) +
                " & name = \"Valheim\"";
        List<Integer> prices;
        Game[] games = igdbDao.loadGamesToRank(whereConditions);
        prices = ranker.getPrices(games);
        assertEquals(games.length, prices.size());
    }

    /**
     * Tests getting game values.
     *
     * @throws Exception the exception
     */
    @Test
    public void getGameValuesSuccess() throws Exception {
        ranker = new Ranker();
        igdbDao = new IgdbDao();
        String whereConditions = "where first_release_date > " +
                igdbDao.getReleaseDateEpoch(157784630);
        Game[] games = igdbDao.loadGamesToRank(whereConditions);
        List<Integer> prices = ranker.getPrices(games);
        List<Double> values = ranker.getGameValues(games, prices);
        assertEquals(500, values.size());
    }

    /**
     * Tests getting a ranked game list.
     *
     * @throws Exception the exception
     */
    @Test
    public void getRankedGameListSuccess() throws Exception {
        ranker = new Ranker();
        igdbDao = new IgdbDao();

        int releaseDate = igdbDao.getReleaseDateEpoch(157784630);
        
        String whereConditions = "where first_release_date > " + releaseDate;

        Game[] games = igdbDao.loadGamesToRank(whereConditions);

        List<RankedGame> rankedGames = ranker.getRankedGameList(games);
        assertEquals(500, rankedGames.size());
    }
}
