package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.User;
import com.kevinleader.bgr.entity.WishedGame;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Wished game dao test.
 */
class WishedGameDaoTest {

    /**
     * The Dao.
     */
    WishedGameDao dao;

    /**
     * Sets up new dao for each test.
     */
    @BeforeEach
    void setUp() {
        dao = new WishedGameDao();
    }

    /**
     * Resets the table after every test.
     */
    @AfterEach
    void tearDown() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);

        WishedGame newWishedGame = new WishedGame(7463, user);
        user.addWishedGame(newWishedGame);

        int id = dao.insert(newWishedGame);

        assertNotEquals(0, id);
        WishedGame insertedWishedGame = dao.getById(id);
        assertEquals(7463, insertedWishedGame.getIgdbGameId());
        assertNotNull(insertedWishedGame.getUser());
        assertEquals("jcoyne", insertedWishedGame.getUser().getUserName());
    }

    /**
     * Tests the getAll method.
     */
    @Test
    void getAllSuccess() {
        List<WishedGame> wishedGames = dao.getAll();
        assertEquals(6, wishedGames.size());
    }

    /**
     * Tests the getById method.
     */
    @Test
    void getByIdSuccess() {
        WishedGame retrievedWishedGame = dao.getById(1);
        assertEquals(113112, retrievedWishedGame.getIgdbGameId());
        assertEquals(4, retrievedWishedGame.getUser().getId());
    }

    /**
     * Gets by igdb game id success.
     */
    @Test
    void getByIgdbGameIdSuccess() {
        List<WishedGame> retrievedWishedGames = dao.getByIgdbGameId(113112);
        assertEquals(2, retrievedWishedGames.size());
    }

    /**
     * Gets by user id success.
     */
    @Test
    void getByUserIdSuccess() {
        List<WishedGame> retrievedWishedGames = dao.getByUserId(2);
        assertEquals(2, retrievedWishedGames.size());
    }

    /**
     * Tests the saveOrUpdate method.
     */
    @Test
    void saveOrUpdateSuccess() {
        int newIgdbGameId = 111469;
        WishedGame wishedGameToUpdate = dao.getById(2);
        wishedGameToUpdate.setIgdbGameId(newIgdbGameId);
        dao.saveOrUpdate(wishedGameToUpdate);
        WishedGame retrievedWishedGame = dao.getById(2);
        assertEquals(newIgdbGameId, retrievedWishedGame.getIgdbGameId());
    }

    /**
     * Tests the delete method.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

}