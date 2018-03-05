package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("orderdetailDAO")
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetails> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from OrderDetails o");
			orderDetails = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			orderDetails = null;
		} finally {
			session.flush();
			session.close();
		}
 		return orderDetails;
	}

	@Override
	public void deleteOrderDetails(OrderDetailsId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete OrderDetails o where id = :id").setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails, OrderDetailsId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update OrderDetails o set password=:password, "
					+"score=:score "
					+ "where id = :id");
			query.setParameter("password",orderDetails.getPrice());
			query.setParameter("score",orderDetails.getPrice());
			query.setParameter("id",id);
			int result=query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public void addOrderDetails(OrderDetails orderDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(orderDetails);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			orderDetails = null;System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public OrderDetails findOrderDetails(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		OrderDetails orderDetails=new OrderDetails();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from OrderDetails o " + 
			"where id = :id");
			query.setParameter("id",id);
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
