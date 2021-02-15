package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.User;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    /**
     * The Dao.
     */
    UserDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User(0, "rphilman", "rphilman@yahoo.com", "finalanswer1mil");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("rphilman", insertedUser.getUserName());
        assertEquals("rphilman@yahoo.com", insertedUser.getEmail());
        assertEquals("finalanswer1mil", insertedUser.getPassword());
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("jcoyne", retrievedUser.getUserName());
        assertEquals("coynemcgoin@hotmail.com", retrievedUser.getEmail());
        assertEquals("supersecret1", retrievedUser.getPassword());
    }

    /**
     * Gets by username success.
     */
    @Test
    void getByUsernameSuccess() {
        String userName = "d";
        List<User> users = dao.getByUsername(userName);
        assertEquals(2, users.size());
    }

    /**
     * Gets by email success.
     */
    @Test
    void getByEmailSuccess() {
        String email = "bacon";
        List<User> users = dao.getByEmail(email);
        assertEquals(1, users.size());
    }

    /**
     * Save or update success.
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
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
}