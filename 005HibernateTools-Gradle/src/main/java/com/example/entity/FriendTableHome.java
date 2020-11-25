package com.example.entity;
// Generated 24 Nov, 2020 7:00:07 PM by Hibernate Tools 5.4.18.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class FriendTable.
 * @see com.example.entity.FriendTable
 * @author Hibernate Tools
 */
public class FriendTableHome {

	private static final Logger logger = Logger.getLogger(FriendTableHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FriendTable transientInstance) {
		logger.log(Level.INFO, "persisting FriendTable instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FriendTable instance) {
		logger.log(Level.INFO, "attaching dirty FriendTable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(FriendTable instance) {
		logger.log(Level.INFO, "attaching clean FriendTable instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(FriendTable persistentInstance) {
		logger.log(Level.INFO, "deleting FriendTable instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public FriendTable merge(FriendTable detachedInstance) {
		logger.log(Level.INFO, "merging FriendTable instance");
		try {
			FriendTable result = (FriendTable) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public FriendTable findById(int id) {
		logger.log(Level.INFO, "getting FriendTable instance with id: " + id);
		try {
			FriendTable instance = (FriendTable) sessionFactory.getCurrentSession()
					.get("com.example.entity.FriendTable", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(FriendTable instance) {
		logger.log(Level.INFO, "finding FriendTable instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.example.entity.FriendTable")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
