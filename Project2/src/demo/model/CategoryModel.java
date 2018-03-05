package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class CategoryModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session=sessionFactory.openSession();
	
	public List<Categories> findAll(){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery("select c "
					+ "from Categories c");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("find all exception");
			return null;
		}
	}
	
	public void Insert(Categories categories){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			session.save(categories);
			//session.getTransaction().commit();
			//session.close();
			session.beginTransaction().commit();
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Delete(int id){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Query query= sessionFactory.getCurrentSession().createQuery
					("delete Categories c where id = :id").setParameter("id", id);
			
			query.executeUpdate();
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Update(int id,Categories categories){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			//session.getTransaction().begin();
			Query query= sessionFactory.getCurrentSession().createQuery
					("update Categories c set name=:name, "
							+"sortOrder=:sortOrder "
							+ "where id = :id");
			query.setParameter("name",categories.getName());
			query.setParameter("sortOrder",categories.getSortOrder());
			query.setParameter("id",id);
			int result=query.executeUpdate();
			sessionFactory.getCurrentSession().getTransaction().commit();
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Categories findCategory(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Categories categories = new Categories();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select c from Categories c " + 
			"where id = :id");
			query.setParameter("id",id);
			categories = (Categories) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categories = null;
		} finally {
			session.flush();
			session.close();
		}
 		return categories;
	}
	
}
