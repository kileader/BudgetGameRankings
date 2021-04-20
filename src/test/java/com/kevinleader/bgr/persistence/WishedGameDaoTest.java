package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.entity.database.WishedGame;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing tests for the GenericDao and WishedGame classes.
 */
class WishedGameDaoTest {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Wished game dao.
     */
    GenericDao wishedGameDao;

    /**
     * The New user.
     */
    User newUser;
    /**
     * The New wished game 1.
     */
    WishedGame newWishedGame1;
    /**
     * The New wished game 2.
     */
    WishedGame newWishedGame2;
    /**
     * The New wished game super.
     */
    WishedGame newWishedGameSuper;
    /**
     * The Wished games.
     */
    List<WishedGame> wishedGames;

    /**
     * Resets database, sets up new DAOs, and creates a new User and WishedGame before each test.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userDao = new GenericDao(User.class);
        wishedGameDao = new GenericDao(WishedGame.class);

        newUser = new User("Ranias", "kevin.i.leader@gmail.com", "password");
        newWishedGame1 = new WishedGame(newUser, "Papers, Please", 2935, 239030);
        newWishedGame2 = new WishedGame(newUser, "Diddy Kong Racing", 2723, -1);
        newWishedGameSuper = new WishedGame(newUser, "Super Monkey Ball: Banana Blitz HD", 120867, 1061730);
    }

    /**
     * Tests inserting a new wished game.
     */
    @Test
    void insertSuccess() {
        int userId = userDao.insert(newUser);
        assertNotEquals(0, userId);

        newUser.addWishedGame(newWishedGame1);
        int id = wishedGameDao.insert(newWishedGame1);
        assertNotEquals(0, id);
    }

    /**
     * Tests getting all wished games.
     */
    @Test
    void getAllSuccess() {
        List<WishedGame> wishedGames = wishedGameDao.getAll();
        assertEquals(8, wishedGames.size());
    }

    /**
     * Tests getting a wished game by id.
     */
    @Test
    void getByIdSuccess() {
        userDao.insert(newUser);
        newUser.addWishedGame(newWishedGame1);
        int id = wishedGameDao.insert(newWishedGame1);

        WishedGame insertedWishedGame = (WishedGame) wishedGameDao.getById(id);
        assertEquals(newWishedGame1.toString(), insertedWishedGame.toString());
    }

    /**
     * Tests getting wished games by exact user.
     */
    @Test
    void getByPropertyEqualSuccess() {
        userDao.insert(newUser);
        wishedGameDao.insert(newWishedGame1);
        wishedGameDao.insert(newWishedGame2);

        wishedGames = wishedGameDao.getByPropertyEqual("user", newUser);
        assertEquals(2, wishedGames.size());
        assertEquals(newWishedGame2.toString(), wishedGames.get(1).toString());
    }

    /**
     * Tests getting a wished game by partial game name.
     */
    @Test
    void getByPropertyLikeSuccess() {
        userDao.insert(newUser);
        wishedGameDao.insert(newWishedGameSuper);
        wishedGames = wishedGameDao.getByPropertyLike("gameName", "Super");
        assertEquals(3, wishedGames.size());
        assertEquals(newWishedGameSuper.toString(), wishedGames.get(2).toString());
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