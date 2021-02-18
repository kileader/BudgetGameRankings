//package com.kevinleader.bgr.persistence;
//
//import com.kevinleader.bgr.entity.User;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Expression;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
///**
// * The data access object for use on the User class.
// */
//public class RankingConfigurationDao {
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    /**
//     * The SessionFactory object for use with Hibernate
//     */
//    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
//
//    /**
//     * Insert a new user
//     *
//     * @param user the user
//     * @return the int
//     */
//    public int insert(User user) {
//        logger.debug("running insert({}");
//        int id;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        id = (int)session.save(user);
//        transaction.commit();
//        session.close();
//        return id;
//    }
//
//    /**
//     * Get all users.
//     *
//     * @return the users
//     */
//    public List<User> getAll() {
//        logger.info("run getAll");
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        List<User> users = session.createQuery(query).getResultList();
//        session.close();
//        return users;
//    }
//
//    /**
//     * Get a user by the table id.
//     *
//     * @param id the id
//     * @return the user
//     */
//    public User getById(int id) {
//        logger.info("run getById");
//        Session session = sessionFactory.openSession();
//        User user = session.get(User.class, id);
//        session.close();
//        return user;
//    }
//
//    /**
//     * Get users by a user name or partial user name
//     *
//     * @param userName the user name
//     * @return list of users that match user name
//     */
//    public List<User> getByUsername(String userName){
//        logger.info("run getByUserName");
//        logger.debug("Searching for: {}", userName);
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        Expression<String> propertyPath = root.get("userName");
//        query.where(builder.like(propertyPath, "%" + userName + "%"));
//        List<User> users = session.createQuery(query).getResultList();
//        session.close();
//        return users;
//    }
//
//    /**
//     * Get user by email or partial email
//     *
//     * @param email the email
//     * @return list of matching users
//     */
//    public List<User> getByEmail(String email){
//        logger.info("run getByEmail");
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        Expression<String> propertyPath = root.get("email");
//        query.where(builder.like(propertyPath, "%" + email + "%"));
//        List<User> users = session.createQuery(query).getResultList();
//        session.close();
//        return users;
//    }
//
//    /**
//     * Update a user.
//     *
//     * @param user the user
//     */
//    public void saveOrUpdate(User user) {
//        logger.info("run saveOrUpdate");
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(user);
//        transaction.commit();
//        session.close();
//    }
//
//    /**
//     * Delete user.
//     *
//     * @param user the user
//     */
//    public void delete(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(user);
//        transaction.commit();
//        session.close();
//    }
//
//}
