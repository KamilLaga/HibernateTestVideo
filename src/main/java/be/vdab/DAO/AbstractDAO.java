package be.vdab.DAO;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

public class AbstractDAO {

	public AbstractDAO() {
		super();
	}

	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		getEntityManager().getTransaction().rollback();
	}

}