package genericdaoattempt;

import java.util.List;

import onedayproject.model.User;

public class UserDaoBAK extends GenericDaoImpl<User> {

	public UserDaoBAK() {
		super(User.class);
	}

    public void persist(User entity) {
        openCurrentSessionwithTransaction();
        create(entity);
        closeCurrentSessionwithTransaction();
    }

    public void update(User model) {
        openCurrentSessionwithTransaction();
        update(model);
        closeCurrentSessionwithTransaction();
    }
 
    public User findById(Integer id) {
        openCurrentSession();
        User user = get(id);
        closeCurrentSession();
        return user;
    }
 
    public void remove(Integer id) {
        openCurrentSessionwithTransaction();
        User user = get(id);
        delete(user);
        closeCurrentSessionwithTransaction();
    }
 
    public List<User> findAll() {
        openCurrentSession();
        List<User> users = getAll();
        closeCurrentSession();
        return users;
    }
 
    public void deleteAll() {
        openCurrentSessionwithTransaction();
        deleteAll();
        closeCurrentSessionwithTransaction();
    }
}

	
	
	
	/*
	final DAConnector connector;

    public UserDao() {
        this(DAConnector.getInstance());
    }
	
    UserDao(DAConnector connector) {
        this.connector = connector;
    }

	public User create(User user) {
		this.connector.getEntityManager().getTransaction().begin();
		this.connector.getEntityManager().persist(user);
		this.connector.getEntityManager().getTransaction().commit();
		return user;
	}
	
	public List<User> findAll() {
		CriteriaBuilder builder = this.connector.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		criteria.select(userRoot);
		return this.connector.getEntityManager().createQuery(criteria).getResultList();
	}
	*/

