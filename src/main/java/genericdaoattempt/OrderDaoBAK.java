package genericdaoattempt;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import onedayproject.model.Order;

public class OrderDaoBAK {

	private final DAConnector connector;
	
    public OrderDaoBAK() {
        this(DAConnector.getInstance());
    }

    // http://stackoverflow.com/a/38915148/2025274
    
    OrderDaoBAK(DAConnector connector) {
        this.connector = connector;
    }
	
	public Order create(Order order) {
		this.connector.getEntityManager().getTransaction().begin();
		this.connector.getEntityManager().persist(order);
		this.connector.getEntityManager().getTransaction().commit();
		return order;
	}
	
	public List<Order> findAll() {
		CriteriaBuilder builder = this.connector.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
		Root<Order> orderRoot = criteria.from(Order.class);
		criteria.select(orderRoot);
		return this.connector.getEntityManager().createQuery(criteria).getResultList();
	}
}
