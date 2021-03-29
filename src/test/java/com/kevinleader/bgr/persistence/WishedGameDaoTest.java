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
 * Class containing tests for the GenericDao and WishedGame classes.
 */
class WishedGameDaoTest {

    GenericDao wishedGameDao;

    /**
     * Sets up new dao for each test.
     */
    @BeforeEach
    void setUp() {
        wishedGameDao = new GenericDao(WishedGame.class);
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
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(1);

        WishedGame newWishedGame = new WishedGame(7463, user);
        user.addWishedGame(newWishedGame);

        int id = wishedGameDao.insert(newWishedGame);

        assertNotEquals(0, id);
        WishedGame insertedWishedGame = (WishedGame) wishedGameDao.getById(id);
        assertEquals(7463, insertedWishedGame.getIgdbGameId());
        assertNotNull(insertedWishedGame.getUser());
        assertEquals("jcoyne", insertedWishedGame.getUser().getUserName());
    }

    /**
     * Tests the getAll method.
     */
    @Test
    void getAllSuccess() {
        List<WishedGame> wishedGames = wishedGameDao.getAll();
        assertEquals(6, wishedGames.size());
    }

    /**
     * Tests the getById method.
     */
    @Test
    void getByIdSuccess() {
        WishedGame retrievedWishedGame = (WishedGame) wishedGameDao.getById(1);
        assertNotNull(retrievedWishedGame);
        assertEquals(113112, retrievedWishedGame.getIgdbGameId());
        assertEquals(4, retrievedWishedGame.getUser().getId());
    }

    /**
     * Tests the saveOrUpdate method.
     */
    @Test
    void saveOrUpdateSuccess() {
        int newIgdbGameId = 111469;
        WishedGame wishedGameToUpdate = (WishedGame) wishedGameDao.getById(2);
        wishedGameToUpdate.setIgdbGameId(newIgdbGameId);
        wishedGameDao.saveOrUpdate(wishedGameToUpdate);
        WishedGame retrievedWishedGame = (WishedGame) wishedGameDao.getById(2);
        assertEquals(newIgdbGameId, retrievedWishedGame.getIgdbGameId());
    }

    /**
     * Tests the delete method.
     */
    @Test
    void deleteSuccess() {
        wishedGameDao.delete(wishedGameDao.getById(3));
        assertNull(wishedGameDao.getById(3));
    }

}