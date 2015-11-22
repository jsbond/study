package bizbee.common.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class BaseDAO<T> {

    protected Log log = LogFactory.getLog(getClass());


    protected EntityManager manager;

    public EntityManager getEntityManager() {
        return manager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.manager = entityManager;
    }

    private Class<T> type;

    public BaseDAO(Class<T> type) {
        this.type = type;
    }

    public void persist(T object) {
        manager.persist(object);
    }

    public T get(Serializable key) {
        return manager.find(type, key);
    }

    public List<T> get() {
        return (List<T>) getSession().createCriteria(type).list();
    }

    public List<T> findAll() {
        final Query q = manager.createQuery("SELECT alias from " + type.getName() + " as alias");
        return q.getResultList();
    }

    public List<T> findAll(int offSet, int limit) {
        final Query query = manager.createQuery("SELECT alias from " + type.getName() + " as alias");
        query.setFirstResult(offSet);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    public T update(T object) {
        return manager.merge(object);
    }

    public void delete(T object) {
        manager.remove(object);
    }

    public List<T> query(String q, String... keys) {
        Query query = manager.createQuery(q);
        for (int i = 0; i < keys.length; i++) {
            query.setParameter(i + 1, keys[i]);
        }
        return (List<T>) query.getResultList();
    }

    public List<T> query(String q, int offSet, int limit, String... keys) {
        final Query query = manager.createQuery(q);
        query.setFirstResult(offSet);
        query.setMaxResults(limit);

        for (int i = 0; i < keys.length; i++) {
            query.setParameter(i + 1, keys[i]);
        }
        return (List<T>) query.getResultList();
    }

    public Long count() {
        final Query q = manager.createQuery("SELECT count(alias) from " + type.getName() + " as alias");
        return (Long) q.getSingleResult();
    }

    protected Session getSession() {
        return ((Session) manager.getDelegate());
    }

    public EntityManager getManager() {
        return manager;
    }

}