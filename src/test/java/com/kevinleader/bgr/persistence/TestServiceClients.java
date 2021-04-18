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
     * Test igdb search from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testIgdbSearchFromGameName() throws Exception {
        igdbDao = new IgdbDao();
        String gameName = "Dark Souls III";
        Game[] games = igdbDao.searchFromGameName(gameName);
        assertEquals(gameName, games[0].getName());
    }

    /**
     * Tests finding a steam id from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testFindSteamIdFromName() throws Exception {
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
    public void testGetPriceOverviewFromId() throws Exception {
        steamDao = new SteamDao();
        int steamId = 892970; // Valheim, an early access game with no Metacritic score
//        int steamId = 601510; // Yu-Gi-Oh! Duel Links, freemium, doesn't work
        PriceOverview appPrice = steamDao.getPriceOverviewFromId(steamId);
        assertEquals(1999, appPrice.getInitial());
    }

}