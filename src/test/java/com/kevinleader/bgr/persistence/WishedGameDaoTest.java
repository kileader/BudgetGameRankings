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

    GenericDao userDao;
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
        User newUser = new User("Ranias", "kevin.i.leader@gmail.com", "password");

        int userId = userDao.insert(newUser);
        assertNotEquals(0, userId);

        WishedGame newWishedGame = new WishedGame(newUser, "Papers, Please", 2935, 239030);
        newUser.addWishedGame(newWishedGame);

        int id = wishedGameDao.insert(newWishedGame);

        assertNotEquals(0, id);
        WishedGame insertedWishedGame = (WishedGame) wishedGameDao.getById(id);
        // Weird error here if equals by the whole json
        assertEquals(newWishedGame.getGameName(), insertedWishedGame.getGameName());
        assertEquals(newUser, insertedWishedGame.getUser());
    }

    /**
     * Tests the getAll method.
     */
    @Test
    void getAllSuccess() {
        List<WishedGame> wishedGames = wishedGameDao.getAll();
        assertEquals(8, wishedGames.size());
    }

    /**
     * Tests the getById method.
     */
    @Test
    void getByIdSuccess() {
        int id = 4;
        WishedGame retrievedWishedGame = (WishedGame) wishedGameDao.getById(id);
        assertEquals(id, retrievedWishedGame.getId());
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