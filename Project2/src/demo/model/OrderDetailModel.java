package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class OrderDetailModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Accounts> findAll(){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery("select c "
					+ "from OrderDetails c");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("find all exception");
			return null;
		}
	}
	public OrderDetails findOrderDetails(int productId, int orderId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		OrderDetails orderDetails=new OrderDetails();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from OrderDetails o " + 
			"where productId = :productId and orderId = :orderId");
			query.setParameter("productId",productId);
			query.setParameter("orderId",orderId);
			orderDetails = (OrderDetails) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			orderDetails = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
 		return orderDetails;
	}
}
