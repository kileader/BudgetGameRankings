package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.database.RankingConfiguration;
import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.entity.database.WishedGame;
import com.kevinleader.bgr.entity.database.Role;
//import com.kevinleader.bgr.entity.database.RankingConfiguration;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    private GenericDao userDao;
    private User newUser;

    /**
     * Resets database, sets up new dao, and creates new user for each test.
     */
    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userDao = new GenericDao(User.class);
        newUser = new User("rphilman", "rphilman@yahoo.com", "finalanswer1mil");
    }

    /**
     * Tests inserting a user.
     */
    @Test
    void insertSuccess() {
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
        int id = userDao.insert(newUser);
        User retrievedUser = (User) userDao.getById(id);
        assertNotNull(retrievedUser);
        assertEquals(newUser, retrievedUser);
    }

    /**
     * Tests getting a user by full username
     */
    @Test
    void getByPropertyEqualSuccess() {
        userDao.insert(newUser);
        List<User> users = userDao.getByPropertyEqual("userName", "rphilman");
        assertEquals(1, users.size());
        assertEquals(newUser, users.get(0));
    }

    /**
     * Tests getting a user by partial username.
     */
    @Test
    void getByPropertyLikeSuccess() {
        userDao.insert(newUser);
        List<User> users = userDao.getByPropertyLike("userName", "r");
        assertEquals(2, users.size());
        assertEquals(newUser, users.get(1));
    }

    /**
     * Tests updating a username.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "kileader";
        User userToUpdate = (User) userDao.getById(2);
        userToUpdate.setUserName(newUserName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) userDao.getById(2);
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
        Role role = new Role(newUser, "underwater_basket_weaver", newUser.getUserName());
        newUser.addRole(role);
        int id = userDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getRoles().size());
    }

    /**
     * Tests inserting a user with wishedGame.
     */
    @Test
    void insertWithWishedGameSuccess() {
        WishedGame wishedGame = new WishedGame(newUser,
                "Hello Kitty and Sanrio Friends Racing", 35243, 370600);
        newUser.addWishedGame(wishedGame);
        int id = userDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getWishedGames().size());
    }

    /**
     * Tests inserting a user with rankingConfiguration.
     */
    @Test
    void insertWithRankingConfigurationSuccess() {
        RankingConfiguration rankConfig = new RankingConfiguration(newUser,
                "Jesus Take The Wheel", "37,5,49,167",
                "24,30,34,36,9", 70000000, 20000);
        newUser.addRankingConfiguration(rankConfig);
        int id = userDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getRankingConfigurations().size());
    }
}