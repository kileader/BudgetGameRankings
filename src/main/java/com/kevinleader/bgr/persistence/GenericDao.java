package com.kevinleader.bgr.persistence;

import java.util.List;
import javax.persistence.criteria.*;

import com.kevinleader.bgr.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 * @param <T> the type parameter
 * @author pawaite
 * @author Kevin Leader
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiate a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Return an open session from the SessionFactory
     *
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Insert an entity.
     *
     * @param entity entity to be inserted
     * @return the int
     */
    public int insert(T entity) {
        logger.debug("run insert({})", entity);
        int id;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Get an entity by id.
     *
     * @param id  the id to search by
     * @return the entity
     */
    public <T>T getById(int id) {
        logger.debug("run getById({})", id);
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Get all entities.
     *
     * @return list of all entities
     */
    public List<T> getAll() {
        logger.debug("run getAll()");
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Find entities by one of its properties exactly.
     *
     * @param propertyName the property name.
     * @param value        the value by which to find.
     * @return list
     */
    public List<T> getByPropertyEqual(String propertyName, Object value) {
        logger.debug("run getByPropertyEqual() with " + propertyName + " = " + value);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName),value));
        List<T> entities = session.createQuery(query).getResultList();
        session.close();
        return entities;
    }

    /**
     * Get entity by property (like)
     * sample usage: getByPropertyLike("lastName", "C")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        logger.debug("run getByPropertyLike() with {} = {}",  propertyName, value);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

    /**
     * Save or update the entity.
     *
     * @param entity entity to be saved or updated
     */
    public void saveOrUpdate(T entity) {
        logger.debug("run saveOrUpdate({})", entity);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Delete the entity.
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        logger.debug("run delete({})", entity);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

}
