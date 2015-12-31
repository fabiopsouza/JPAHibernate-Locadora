package br.com.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.locadora.util.JPAUtil;

public abstract class RepositoryBase <T> {

	private EntityManager em;
	private Class<T> clazz;
	
	public RepositoryBase(Class<T> clazz){
		this.em = new JPAUtil().getEntityManager();
		this.clazz = clazz;
	}
	
	public List<T> get(){
		em.getTransaction().begin();
		List<T> list = em.createQuery("FROM " + clazz.getName()).getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}
	
	public T getById(int id){
		em.getTransaction().begin();
		T obj = (T)em.find(clazz, id);
		em.getTransaction().commit();
		em.close();
		return obj;
	}
	
	public void create(T entity){
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(T entity){
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(T entity){
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}
	
}
