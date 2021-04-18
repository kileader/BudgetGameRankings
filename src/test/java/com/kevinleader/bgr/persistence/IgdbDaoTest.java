package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.igdb.Game;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IgdbDaoTest {

    IgdbDao igdbDao;

    @BeforeEach
    public void setUp() {
        igdbDao = new IgdbDao();
    }

    /**
     * Test igdb search from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSearchFromGameName() throws Exception {
        String gameName = "Dark Souls III";
        Game[] games = igdbDao.searchFromGameName(gameName);
        assertEquals(gameName, games[0].getName());
    }

    @Test
    public void testLoadGamesToRank() throws Exception {
        String platforms = " & platforms = (5,167,169)"; // is on PC, xbox series x, or playstation 5
        String genres = " & genres = (31,12,32,25,8)"; // is an adventure, rpg, indie, hack and slash, or platformer game (DesignDocuments.genreId.txt)
        int releaseEpoch = igdbDao.getReleaseDateEpoch(31556926);
        String releaseDate = " & first_release_date > " + releaseEpoch; // released within a year ago
    }
}

