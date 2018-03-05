package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Orders> orders = new ArrayList<Orders>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from Orders o");
			orders = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			orders = null;
		} finally {
			session.flush();
			session.close();
		}
 		return orders;
	}

	@Override
	public void deleteOrder(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Orders o where id = :id").setParameter("id", id);
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
	public void updateOrder(Orders orders, int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Orders o set "
					+"status=:status,"
					+ "customerPhone=:customerPhone, "
					+ "orderDate=:orderDate, "
					+ "customerAddress=:customerAddress, "
					+ "customerName=:customerName, "
					+ "userId=:userId "
					+ "where id = :id");
			
			query.setParameter("status",orders.isStatus());
			query.setParameter("customerPhone",orders.getCustomerPhone());
			query.setParameter("orderDate",orders.getOrderDate());
			query.setParameter("customerAddress",orders.getCustomerAddress());
			query.setParameter("customerName",orders.getCustomerName());
			query.setParameter("userId",orders.getAccounts().getId());
			query.setParameter("id",id);
			int result=query.executeUpdate();
			transaction.commit();
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
	public void addOrder(Orders orders) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(orders);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			orders = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public Orders findOrder(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Orders orders=new Orders();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from Orders o " + 
			"where id = :id");
			query.setParameter("id",id);
			orders =  (Orders) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
orders = null;
		} finally {
			session.flush();
			session.close();
		}
 		return orders;
	}

	
	
}
