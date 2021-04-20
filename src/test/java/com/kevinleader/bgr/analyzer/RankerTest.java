package com.kevinleader.bgr.analyzer;

import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.ranker.RankedGame;
import com.kevinleader.bgr.persistence.IgdbDao;
import com.kevinleader.bgr.persistence.SteamDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Ranker test.
 */
public class RankerTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Ranker.
     */
    Ranker ranker;
    /**
     * The Igdb dao.
     */
    IgdbDao igdbDao;
    /**
     * The Steam dao.
     */
    SteamDao steamDao;

    /**
     * Gets prices success.
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
     * Gets game values success.
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
     * Gets ranked game list success.
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
        List<String> names = igdbDao.getNames(games);
        List<Integer> prices = ranker.getPrices(games);
        List<Double> values = ranker.getGameValues(games, prices);
        List<RankedGame> rankedGames = ranker.getRankedGameList(names, values);
        assertEquals(500, rankedGames.size());
    }


}
