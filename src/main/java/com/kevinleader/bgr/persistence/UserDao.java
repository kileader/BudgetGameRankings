package com.kevinleader.bgr.persistence;

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
 * The type User dao.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public int insert(User user) {
        logger.info("run insert");
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAll() {
        logger.info("run getAll");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        logger.info("run getById");
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    /**
     * Get users by username list.
     *
     * @param userName the user name
     * @return the list
     */
    public List<User> getByUsername(String userName){
        logger.info("run getByUserName");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.like(propertyPath, "%" + userName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Get by email list.
     *
     * @param email the email
     * @return the list
     */
    public List<User> getByEmail(String email){
        logger.info("run getByEmail");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("email");
        query.where(builder.like(propertyPath, "%" + email + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    public void saveOrUpdate(User user) {
        logger.info("run saveOrUpdate");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Delete user.
     *
     * @param user the user
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

}
