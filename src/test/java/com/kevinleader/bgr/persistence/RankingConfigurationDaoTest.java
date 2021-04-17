//package com.kevinleader.bgr.persistence;
//
//import com.kevinleader.bgr.entity.database.RankingConfiguration;
//import com.kevinleader.bgr.entity.database.User;
//import com.kevinleader.bgr.test.util.Database;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * The type Wished game dao test.
// */
//class RankingConfigurationDaoTest {
//
//    /**
//     * The Dao.
//     */
//    RankingConfigurationDao dao;
//
//    /**
//     * Sets up new dao for each test.
//     */
//    @BeforeEach
//    void setUp() {
//        dao = new RankingConfigurationDao();
//    }
//
//    /**
//     * Resets the table after every test.
//     */
//    @AfterEach
//    void tearDown() {
//        Database database = Database.getInstance();
//        database.runSQL("cleandb.sql");
//    }
//
//    /**
//     * Insert success.
//     */
//    @Test
//    void insertSuccess() {
//        UserDao userDao = new UserDao();
//        User user = userDao.getById(4);
//
//        RankingConfiguration newRankingConfiguration = new RankingConfiguration(7463, user);
//        user.addRankingConfiguration(newRankingConfiguration);
//
//        int id = dao.insert(newRankingConfiguration);
//
//        assertNotEquals(0, id);
//        RankingConfiguration insertedRankingConfiguration = dao.getById(id);
//        assertEquals(7463, insertedRankingConfiguration.getIgdbGameId());
//        assertNotNull(insertedRankingConfiguration.getUser());
//        assertEquals("jcoyne", insertedRankingConfiguration.getUser().getUserName());
//    }
//
//    /**
//     * Tests the getAll method.
//     */
//    @Test
//    void getAllSuccess() {
//        List<RankingConfiguration> RankingConfigurations = dao.getAll();
//        assertEquals(6, RankingConfigurations.size());
//    }
//
//    /**
//     * Tests the getById method.
//     */
//    @Test
//    void getByIdSuccess() {
//        RankingConfiguration retrievedRankingConfiguration = dao.getById(1);
//        assertEquals(113112, retrievedRankingConfiguration.getIgdbGameId());
//        assertEquals(4, retrievedRankingConfiguration.getUser().getId());
//    }
//
//    /**
//     * Gets by igdb game id success.
//     */
//    @Test
//    void getByIgdbGameIdSuccess() {
//        List<RankingConfiguration> retrievedRankingConfigurations = dao.getByIgdbGameId(113112);
//        assertEquals(2, retrievedRankingConfigurations.size());
//    }
//
//    /**
//     * Gets by user id success.
//     */
//    @Test
//    void getByUserIdSuccess() {
//        List<RankingConfiguration> retrievedRankingConfigurations = dao.getByUserId(2);
//        assertEquals(2, retrievedRankingConfigurations.size());
//    }
//
//    /**
//     * Tests the saveOrUpdate method.
//     */
//    @Test
//    void saveOrUpdateSuccess() {
//        int newIgdbGameId = 111469;
//        RankingConfiguration RankingConfigurationToUpdate = dao.getById(2);
//        RankingConfigurationToUpdate.setIgdbGameId(newIgdbGameId);
//        dao.saveOrUpdate(RankingConfigurationToUpdate);
//        RankingConfiguration retrievedRankingConfiguration = dao.getById(2);
//        assertEquals(newIgdbGameId, retrievedRankingConfiguration.getIgdbGameId());
//    }
//
//    /**
//     * Tests the delete method.
//     */
//    @Test
//    void deleteSuccess() {
//        dao.delete(dao.getById(3));
//        assertNull(dao.getById(3));
//    }
//
//}
