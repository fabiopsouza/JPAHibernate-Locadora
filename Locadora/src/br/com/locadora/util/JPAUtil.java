package br.com.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityMenagerFactory = Persistence.createEntityManagerFactory("locadora");
	
	public EntityManager getEntityManager() {
		return entityMenagerFactory.createEntityManager();
	}

}
