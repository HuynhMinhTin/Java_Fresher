package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;


import demo.entities.*;

public class CategoryLanguagesModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<CategoryLanguages> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<CategoryLanguages> categoryLanguages = new ArrayList<CategoryLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from CategoryLanguages a");
			categoryLanguages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categoryLanguages = null;
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
 		return categoryLanguages;
	
	}
	
}
