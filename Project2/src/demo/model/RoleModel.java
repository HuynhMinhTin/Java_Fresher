package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class RoleModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Roles> findAll(){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery("select c "
					+ "from Roles c");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("find all exception");
			return null;
		}
	}
	
}
