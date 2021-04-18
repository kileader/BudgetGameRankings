package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.steam.PriceOverview;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SteamDaoTest {

    private SteamDao steamDao;

    @BeforeEach
    public void setUp() {
        steamDao = new SteamDao();
    }

    /**
     * Tests finding a steam id from game name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testFindSteamIdFromName() throws Exception {
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
        int steamId = 892970; // Valheim, an early access game with no Metacritic score
//        int steamId = 601510; // Yu-Gi-Oh! Duel Links, freemium, doesn't work
        PriceOverview appPrice = steamDao.getPriceOverviewFromId(steamId);
        assertEquals(1999, appPrice.getInitial());
    }
}
