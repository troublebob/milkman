package genericdaoattempt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class GenericDaoImpl<T> implements GenericDaoInterface<T, Integer> {

	private Session currentSession;
	     
    private Transaction currentTransaction;
	
    private Class<T> type;
    
    public GenericDaoImpl(Class<T> type) {
    	this.type = type;
    }
    
	public void create(T model) {
		getCurrentSession().save(model);
	}

	public void update(T model) {
		getCurrentSession().update(model);
	}

	public T get(Integer id) {
		T model = (T) getCurrentSession().get(type, id);
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> models = (List<T>) getCurrentSession().createCriteria(type).list();
//        List<T> models = (List<T>) getCurrentSession().createQuery("from Book").list();
        return models;
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteAll() {
        List<T> models = getAll();
        for (T model: models) {
        	delete(model);
        }
	}
	
	public Session openCurrentSession() {
	    currentSession = getSessionFactory().openSession();
	    return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
	    currentSession = getSessionFactory().openSession();
	    currentTransaction = currentSession.beginTransaction();
	    return currentSession;
	}
	 
	public void closeCurrentSession() {
	    currentSession.close();
	}
	 
	public void closeCurrentSessionwithTransaction() {
	    currentTransaction.commit();
	    currentSession.close();
	}
	 
	private static SessionFactory getSessionFactory() {
	    Configuration configuration = new Configuration().configure();
	    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	            .applySettings(configuration.getProperties());
	    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
	    return sessionFactory;
	}

	public Session getCurrentSession() {
	    return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
	    this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
	    return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
	    this.currentTransaction = currentTransaction;
	}
}
