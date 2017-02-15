package onedayproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAConnector {
	private static DAConnector source;
	private EntityManagerFactory emf;
	EntityManager em;
	
	public static DAConnector getInstance() {
		if (source == null) {
			source = new DAConnector();
		}
		return source;
	}

	private DAConnector() {
		this.emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}	
	public EntityManagerFactory getEntityManagerFactory(){
		return emf;
	}
}
