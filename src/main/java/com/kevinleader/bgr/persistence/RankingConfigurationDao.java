package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.RankingConfiguration;
import com.kevinleader.bgr.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The data access object for use on the RankingConfiguration class.
 */
public class RankingConfigurationDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The SessionFactory object for use with Hibernate
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Insert a new ranking configuration.
     *
     * @param rankingConfiguration the ranking configuration
     * @return the int
     */
    public int insert(RankingConfiguration rankingConfiguration) {
        logger.debug("run insert({})", rankingConfiguration);
        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(rankingConfiguration);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Get all ranking configurations.
     *
     * @return the ranking configurations
     */
    public List<RankingConfiguration> getAll() {
        logger.debug("run getAll()");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RankingConfiguration> query = builder.createQuery(RankingConfiguration.class);
        Root<RankingConfiguration> root = query.from(RankingConfiguration.class);
        List<RankingConfiguration> rankingConfigurations = session.createQuery(query).getResultList();
        session.close();
        return rankingConfigurations;
    }

    /**
     * Get a ranking configuration by the table id.
     *
     * @param id the id
     * @return the ranking configuration
     */
    public RankingConfiguration getById(int id) {
        logger.debug("run getById({})", id);
        Session session = sessionFactory.openSession();
        RankingConfiguration rankingConfiguration = session.get(RankingConfiguration.class, id);
        session.close();
        return rankingConfiguration;
    }

    /**
     * Gets by configuration name.
     *
     * @param configurationName the configuration name
     * @return the by configuration name
     */
    public List<RankingConfiguration> getByConfigurationName(String configurationName) {
        logger.debug("run getByConfigurationName({})", configurationName);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RankingConfiguration> query = builder.createQuery(RankingConfiguration.class);
        Root<RankingConfiguration> root = query.from(RankingConfiguration.class);
        Expression<String> propertyPath = root.get("configurationName");
        query.where(builder.like(propertyPath, "%" + configurationName + "%"));
        List<RankingConfiguration> rankingConfigurations = session.createQuery(query).getResultList();
        session.close();
        return rankingConfigurations;
    }

    /**
     * Get by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    public List<RankingConfiguration> getByUserId(int userId){
        logger.debug("run getByUserId({})", userId);
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RankingConfiguration> criteria = builder.createQuery(RankingConfiguration.class);
        Root<RankingConfiguration> root = criteria.from(RankingConfiguration.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("user"), user));
        List<RankingConfiguration> rankingConfigurations = session.createQuery(criteria).getResultList();
        session.close();
        return rankingConfigurations;
    }

    /**
     * Save or update.
     *
     * @param rankingConfiguration the ranking configuration
     */
    public void saveOrUpdate(RankingConfiguration rankingConfiguration) {
        logger.debug("run saveOrUpdate({})", rankingConfiguration);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(rankingConfiguration);
        transaction.commit();
        session.close();
    }

    /**
     * Delete.
     *
     * @param rankingConfiguration the ranking configuration
     */
    public void delete(RankingConfiguration rankingConfiguration) {
        logger.debug("run delete({})", rankingConfiguration);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(rankingConfiguration);
        transaction.commit();
        session.close();
    }

}
