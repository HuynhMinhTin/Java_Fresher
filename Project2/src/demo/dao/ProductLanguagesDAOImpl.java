package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("productlanguageDAO")
public class ProductLanguagesDAOImpl implements ProductLanguagesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductLanguages> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<ProductLanguages> productLanguages = new ArrayList<ProductLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from ProductLanguages pl");
			productLanguages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			productLanguages = null;
		} finally {
			session.flush();
			session.close();
		}
 		return productLanguages ;
	}

	

	@Override
	public ProductLanguages findProductLanguages(String languageID,int productID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		ProductLanguages productLanguages=new ProductLanguages();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from ProductLanguages pl " + 
			"where languageID = :languageID and productID = :productID");
			query.setParameter("languageID",languageID);
			query.setParameter("productID",productID);
			productLanguages = (ProductLanguages) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			productLanguages = null;
		} finally {
			session.flush();
			session.close();
		}
 		return productLanguages;
	}



	@Override
	public List<ProductLanguages> findProductbyLanguages(String languageID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<ProductLanguages> productLanguages = new ArrayList<ProductLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from ProductLanguages pl where languageID = :languageID");
			query.setParameter("languageID",languageID);
			productLanguages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			productLanguages = null;
		} finally {
			session.flush();
			session.close();
		}
 		return productLanguages ;
	}



	@Override
	public void deleteProductLanguages(ProductLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete ProductLanguages pl where id = :id").setParameter("id", id);
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
	public void updateProductLanguages(ProductLanguages productLanguages, ProductLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update ProductLanguages pls set name=:name, "
					+"descriptions=:descriptions "
					+ "where id = :id");
			query.setParameter("name",productLanguages.getName());
			query.setParameter("descriptions",productLanguages.getDescriptions());
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
	public void addProductLanguages(ProductLanguages productLanguages) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(productLanguages);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			productLanguages = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public boolean isDuplicate(ProductLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		ProductLanguages productLanguages=new ProductLanguages();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from ProductLanguages pl " + 
			"where id= :id");
			query.setParameter("id",id);
			if( query.uniqueResult()!=null){
				return true;
			}
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		} finally {
			session.flush();
			session.close();
		}
 		return false;
	}

	@Override
	public List<ProductLanguages> findByCategory(String languageID,int categoryID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<ProductLanguages> products = new ArrayList<ProductLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from ProductLanguages pl " + 
			"where languageID = :languageID and products.categories.id = :categoryID");
			query.setParameter("languageID",languageID);
			query.setParameter("categoryID",categoryID);
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
