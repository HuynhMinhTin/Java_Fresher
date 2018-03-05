package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Categories> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Categories> categories = new ArrayList<Categories>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select c from Categories c");
			categories = query.list();
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
	

	

	@Override
	public void deleteCategory(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Categories c where id = :id").setParameter("id", id);
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
	public void updateCategory(Categories categories, int id) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Categories c set name=:name, "
					+"sortOrder=:sortOrder "
					+ "where id = :id");
			query.setParameter("name",categories.getName());
			query.setParameter("sortOrder",categories.getSortOrder());
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
	public void addCategory(Categories categories) {
	
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(categories);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categories = null;
		} finally {
			session.flush();
			session.close();
		}
 		
	}




	@Override
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
