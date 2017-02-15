package onedayproject.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class HibernateTestCheck {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("default");
		
		EntityManager em;
		em = emf.createEntityManager();
		
		User testuser = new User("Hello","Test","Mega");

		Order order = new Order(testuser);
		
		Product milk = new Product("Milk", 1);
		OrderItem milk_orderitem = new OrderItem(order, milk, 10);

		Product butter = new Product("Butter", 2);
		OrderItem butter_orderitem = new OrderItem(order, butter, 10);
		
		em.getTransaction().begin();
		em.persist(testuser);
		
		em.persist(milk);
		em.persist(butter);

		em.persist(milk_orderitem);
		em.persist(butter_orderitem);
		
		em.persist(order);
		em.getTransaction().commit();
	}

}
