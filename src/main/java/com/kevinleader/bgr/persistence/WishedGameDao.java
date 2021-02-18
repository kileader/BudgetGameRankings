package com.kevinleader.bgr.persistence;

import com.kevinleader.bgr.entity.WishedGame;
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
 * The data access object for use on the WishedGame class.
 */
public class WishedGameDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The SessionFactory object for use with Hibernate
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Insert a new wished game
     *
     * @param wishedGame the wished game
     * @return the int
     */
    public int insert(WishedGame wishedGame) {
        logger.debug("run insert({})", wishedGame);
        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(wishedGame);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Get all wished games.
     *
     * @return the wished games
     */
    public List<WishedGame> getAll() {
        logger.debug("run getAll()");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WishedGame> query = builder.createQuery(WishedGame.class);
        Root<WishedGame> root = query.from(WishedGame.class);
        List<WishedGame> wishedGames = session.createQuery(query).getResultList();
        session.close();
        return wishedGames;
    }

    /**
     * Get a wished game by the table id.
     *
     * @param id the id
     * @return the wished game
     */
    public WishedGame getById(int id) {
        logger.debug("run getById({})", id);
        Session session = sessionFactory.openSession();
        WishedGame wishedGame = session.get(WishedGame.class, id);
        session.close();
        return wishedGame;
    }

    public List<WishedGame> getByIgdbGameId(int igdbGameId){
        logger.debug("run getByIgdbGameId({})", igdbGameId);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WishedGame> query = builder.createQuery(WishedGame.class);
        Root<WishedGame> root = query.from(WishedGame.class);
        Expression<String> propertyPath = root.get("igdbGameId");
        query.where(builder.like(propertyPath, String.valueOf(igdbGameId)));
        List<WishedGame> wishedGames = session.createQuery(query).getResultList();
        session.close();
        return wishedGames;
    }

    public List<WishedGame> getByUserId(int userId){
        logger.debug("run getByUserId({})", userId);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WishedGame> query = builder.createQuery(WishedGame.class);
        Root<WishedGame> root = query.from(WishedGame.class);
        Expression<String> propertyPath = root.get("userId");
        query.where(builder.like(propertyPath, String.valueOf(userId)));
        List<WishedGame> wishedGames = session.createQuery(query).getResultList();
        session.close();
        return wishedGames;
    }

    public void saveOrUpdate(WishedGame wishedGame) {
        logger.debug("run saveOrUpdate({})", wishedGame);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(wishedGame);
        transaction.commit();
        session.close();
    }

    public void delete(WishedGame wishedGame) {
        logger.debug("run delete({})", wishedGame);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(wishedGame);
        transaction.commit();
        session.close();
    }

}
