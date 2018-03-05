package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Products> findAll() {
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

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Products p where id = :id").setParameter("id", id);
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
	public void updateProduct(Products products, int id) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Products p set name=:name, "
					+"createDate=:createDate, "
					+"images=:images, "
					+"price=:price, "
					+"descriptions=:descriptions "
					+ "where id = :id");
			query.setParameter("name",products.getName());
			query.setParameter("createDate",products.getCreateDate());
			query.setParameter("images",products.getImages());
			query.setParameter("price",products.getPrice());
			query.setParameter("descriptions",products.getDescriptions());
			//query.setParameter("sortOrder",products.getSortOrder());
			query.setParameter("id",id);
			int result=query.executeUpdate();
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.flush();
			session.close();
		}
 		
	}
	@Override
	public void addProduct(Products products) {
	
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(products);
			transaction.commit();
			System.out.println("Success");
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
 		
	}

	@Override
	public Products findProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Products products=new Products();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select p from Products p " + 
			"where id = :id");
			query.setParameter("id",id);
			products = (Products) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
			products = null;
		} finally {
			session.flush();
			session.close();
		}
 		return products;
	}

	@Override
	public List<Products> findByCategory(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Products> products = new ArrayList<Products>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select p from Products p " + 
			"where categories.id = :id");
			query.setParameter("id",id);
			products =  query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			products = null;
		} finally {
			session.flush();
			session.close();
		}
 		return products;
	}
	
}
