package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class OrderModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Products> findAll(){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery("select c "
					+ "from Orders c");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("find all exception");
			return null;
		}
	}
	
}
