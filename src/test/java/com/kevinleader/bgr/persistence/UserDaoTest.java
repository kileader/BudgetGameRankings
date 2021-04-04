package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.User;
import com.kevinleader.bgr.entity.WishedGame;
import com.kevinleader.bgr.entity.Role;
//import com.kevinleader.bgr.entity.RankingConfiguration;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao userDao;

    /**
     * Sets up new dao for each test.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
    }

    /**
     * Resets the test database.
     */
    @AfterEach
    void tearDown(){
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Tests inserting a user.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");
        int id = userDao.insert(newUser);
        assertNotEquals(0, id);
    }

    /**
     * Tests getting all users.
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Tests getting a user by id.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)userDao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("fhensen", retrievedUser.getUserName());
    }

    /**
     * Tests getting a user by full username
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDao.getByPropertyEqual("userName", "jcoyne");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Tests getting a user by partial username.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDao.getByPropertyLike("userName", "k");
        assertEquals(2, users.size());
    }

    /**
     * Tests updating a username.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "kileader";
        User userToUpdate = (User)userDao.getById(2);
        userToUpdate.setUserName(newUserName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(2);
        assertEquals(newUserName, retrievedUser.getUserName());
    }

    /**
     * Tests deleting a user
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }


    /**
     * Tests inserting a user with a role.
     */
    @Test
    void insertWithRoleSuccess() {
        User newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");

        String roleName = "user";
        Role role = new Role(newUser, "underwater_basket_weaver", newUser.getUserName());

        newUser.addRole(role);

        int id = userDao.insert(newUser);

        assertNotEquals(0, id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals("rphilman", insertedUser.getUserName());
        assertEquals(1, insertedUser.getRoles().size());
    }

    /**
     * Tests inserting a user with wishedGame.
     */
    @Test
    void insertWithWishedGameSuccess() {
        User newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");

        int igdbGameId = 113112;
        WishedGame wishedGame = new WishedGame(igdbGameId, newUser);

        newUser.addWishedGame(wishedGame);

        int id = userDao.insert(newUser);

        assertNotEquals(0, id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals("rphilman", insertedUser.getUserName());
        assertEquals(1, insertedUser.getWishedGames().size());
    }
}