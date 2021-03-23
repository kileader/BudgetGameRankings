package com.kevinleader.bgr.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.*;

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
     * @param id the id to search by
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
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Find entities by one of its properties.
     *
     * @param propertyName the property name.
     * @param value the value by which to find.
     * @return
     */
    public List<T> findByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName),value));
        return session.createQuery(query).getResultList();
    }

    /**
     * Find entities by multiple properties.
     * Inspired by https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
     *
     * @param propertyMap property and value pairs
     * @return entities with properties equal to those passed in the map
     */
    public List<T> findByPropertyEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry entry: propertyMap.entrySet()) {
            predicates.add(builder.equal(root.get((String) entry.getKey()), entry.getValue()));
        }
        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        return session.createQuery(query).getResultList();
    }

    /**
     * Insert or update the entity.
     *
     * @param entity entity to be inserted/saved
     */
    public void saveOrUpdate(T entity) {
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
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

}
