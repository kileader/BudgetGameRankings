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
 * Class containing tests for the WishedGame class.
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
     * Tests the insert method.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("rphilman", insertedUser.getUserName());
        assertEquals("rphilman@yahoo.com", insertedUser.getEmail());
        assertEquals("finalanswer1mil", insertedUser.getPassword());
    }

    /**
     * Tests the getAll method.
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Tests the getById method.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("jcoyne", retrievedUser.getUserName());
        assertEquals("coynemcgoin@hotmail.com", retrievedUser.getEmail());
        assertEquals("supersecret1", retrievedUser.getPassword());
    }

    /**
     * Tests the getByUsername method.
     */
    @Test
    void getByUsernameSuccess() {
        String userName = "d";
        List<User> users = dao.getByUsername(userName);
        assertEquals(2, users.size());
    }

    /**
     * Tests the getByEmail method.
     */
    @Test
    void getByEmailSuccess() {
        String email = "bacon";
        List<User> users = dao.getByEmail(email);
        assertEquals(1, users.size());
    }

    /**
     * Tests the saveOrUpdate method.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "kileader";
        User userToUpdate = dao.getById(2);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(2);
        assertEquals(newUserName, retrievedUser.getUserName());
    }

    /**
     * Tests the delete method.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Tests the insert method.
     */
    @Test
    void insertWithWishedGameSuccess() {
        User newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");

        int igdbGameId = 113112;
        WishedGame wishedGame = new WishedGame(igdbGameId, newUser);

        newUser.addWishedGame(wishedGame);

        int id = dao.insert(newUser);

        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("rphilman", insertedUser.getUserName());
        assertEquals(1, insertedUser.getWishedGames().size());
    }

    /**
     * Resets the table after every test.
     */
    @AfterEach
    void tearDown() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
}