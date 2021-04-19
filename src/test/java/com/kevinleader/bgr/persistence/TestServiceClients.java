package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.steam.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests various capabilities from APIs used in project.
 */
public class TestServiceClients {

    IgdbDao igdbDao;
    SteamDao steamDao;

    /**
     * Tests igdb search from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void igdbSearchFromGameNameSuccess() throws Exception {
        igdbDao = new IgdbDao();
        String gameName = "Dark Souls III";
        Game[] games = igdbDao.searchFromGameName(gameName);
        assertEquals(gameName, games[0].getName());
    }

    /**
     * Tests load games to rank via igdb post.
     *
     * @throws Exception the exception
     */
    @Test
    public void loadGamesToRankSuccess() throws Exception {
        igdbDao = new IgdbDao();
        String platforms = " & platforms = (5,167,169)"; // is on PC, xbox series x, or playstation 5
        String genres = " & genres = (31,12,32,25,8)"; // is an adventure, rpg, indie, hack and slash, or platformer game (DesignDocuments.genreId.txt)
        int releaseEpoch = igdbDao.getReleaseDateEpoch(31556926);
        String releaseDate = " & first_release_date > " + releaseEpoch; // released within a year ago
//        String whereCondition = releaseDate;
        String whereCondition = platforms + genres + releaseDate;
        Game[] games = igdbDao.loadGamesToRank(whereCondition);
        assertEquals("It Takes Two", games[0].getName());
    }

    /**
     * Tests finding a steam id from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void findSteamIdFromNameSuccess() throws Exception {
        steamDao = new SteamDao();
        String gameName = "test2";
        int expectedAppId = 660010;

        int receivedId = steamDao.findSteamIdFromName(gameName);
        assertEquals(expectedAppId, receivedId);
    }

    /**
     * Test find steam game details from id.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPriceOverviewFromIdSuccess() throws Exception {
        steamDao = new SteamDao();
        int steamId = 892970; // Valheim, an early access game with no Metacritic score
//        int steamId = 601510; // Yu-Gi-Oh! Duel Links, freemium, doesn't work
        PriceOverview appPrice = steamDao.getPriceOverviewFromId(steamId);
        assertEquals(1999, appPrice.getInitial());
    }

}