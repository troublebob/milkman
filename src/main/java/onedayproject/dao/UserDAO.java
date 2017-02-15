package onedayproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

import onedayproject.model.User;


public class UserDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public UserDAO() {
		this.emf=DAConnector.getInstance().getEntityManagerFactory();
		this.em =DAConnector.getInstance().getEntityManager();
	}
	
	public UserDAO(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}
	public void close() {
		if(this.em != null){// && this.emf != null){
			this.em.close();
			//this.emf.close();
		}
	}
	public void save(User user) throws RollbackException {
		this.em.getTransaction().begin();
		this.em.persist(user);
		this.em.getTransaction().commit();
	}
	
}
