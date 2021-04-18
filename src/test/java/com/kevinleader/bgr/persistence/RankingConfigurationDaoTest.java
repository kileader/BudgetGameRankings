package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.database.RankingConfiguration;
import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RankingConfigurationDaoTest {

    GenericDao userDao;
    GenericDao rankingConfigurationDao;
    User newUser;
    RankingConfiguration defaultConfig;
    RankingConfiguration newConfig;
    List<RankingConfiguration> rankConfigs;

    /**
     * Resets database, sets up new DAOs, and creates a new User and RankingConfiguration before each test.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userDao = new GenericDao(User.class);
        rankingConfigurationDao = new GenericDao(RankingConfiguration.class);

        newUser = new User("Ranias", "kevin.i.leader@gmail.com", "password");
        defaultConfig = new RankingConfiguration(newUser,
                "Any Game For Past Year", "Any",
                "Any", 31556926, 7000);
        newConfig = new RankingConfiguration(newUser,
                "Jesus Take The Wheel", "37,5,49,167",
                "24,30,34,36,9", 70000000, 20000);
    }

    /**
     * Tests inserting a new ranking configuration.
     */
    @Test
    void insertSuccess() {
        int userId = rankingConfigurationDao.insert(newUser);
        assertNotEquals(0, userId);

        newUser.addRankingConfiguration(defaultConfig);
        int id = rankingConfigurationDao.insert(defaultConfig);
        assertNotEquals(0, id);
    }

    /**
     * Tests getting all ranking configurations.
     */
    @Test
    void getAllSuccess() {
        List<RankingConfiguration> rankConfigs = rankingConfigurationDao.getAll();
        assertEquals(6, rankConfigs.size());
    }

    /**
     * Tests getting a ranking configuration by id.
     */
    @Test
    void getByIdSuccess() {
        userDao.insert(newUser);
        newUser.addRankingConfiguration(defaultConfig);
        int id = rankingConfigurationDao.insert(defaultConfig);

        RankingConfiguration insertedRankConfig = (RankingConfiguration) rankingConfigurationDao.getById(id);
        assertEquals(defaultConfig.toString(), insertedRankConfig.toString());
    }

    /**
     * Tests getting ranking configurations by exact user.
     */
    @Test
    void getByPropertyEqualSuccess() {
        userDao.insert(newUser);
        rankingConfigurationDao.insert(defaultConfig);
        rankingConfigurationDao.insert(newConfig);

        rankConfigs = rankingConfigurationDao.getByPropertyEqual("user", newUser);
        assertEquals(2, rankConfigs.size());
        assertEquals(newConfig.toString(), rankConfigs.get(1).toString());
    }

    /**
     * Tests getting a wished game by partial game name.
     */
    @Test
    void getByPropertyLikeSuccess() {
        userDao.insert(newUser);
        rankingConfigurationDao.insert(defaultConfig);
        rankingConfigurationDao.insert(newConfig);
        rankConfigs = rankingConfigurationDao.getByPropertyLike("genres", "30");
        assertEquals(1, rankConfigs.size());
        assertEquals(newConfig.toString(), rankConfigs.get(0).toString());
    }

    /**
     * Tests the saveOrUpdate method.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newPlatforms = "39,34";
        RankingConfiguration rankConfigToUpdate = (RankingConfiguration) rankingConfigurationDao.getById(2);
        rankConfigToUpdate.setPlatforms(newPlatforms);
        rankingConfigurationDao.saveOrUpdate(rankConfigToUpdate);
        RankingConfiguration retrievedRankConfig = (RankingConfiguration) rankingConfigurationDao.getById(2);
        assertEquals(newPlatforms, retrievedRankConfig.getPlatforms());
    }

    /**
     * Tests the delete method.
     */
    @Test
    void deleteSuccess() {
        rankingConfigurationDao.delete(rankingConfigurationDao.getById(3));
        assertNull(rankingConfigurationDao.getById(3));
    }

}