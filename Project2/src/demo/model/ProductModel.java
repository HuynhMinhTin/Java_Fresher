package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class ProductModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Products> findAll(){
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Products> products = new ArrayList<Products>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select p from Products p");
			products = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			products = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
 		return products;
	}
	
	public void Insert(){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery("insert into Product()"
					+ "from Products c");
			int result= query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("find all exception");
			
		}
	}
}
