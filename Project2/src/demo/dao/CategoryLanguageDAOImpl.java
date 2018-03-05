package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguagesId;
@Repository("categorylanguageDAO")
public class CategoryLanguageDAOImpl implements CategoryLanguageDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<CategoryLanguages> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<CategoryLanguages> categoryLanguages = new ArrayList<CategoryLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select cl from CategoryLanguages cl");
			categoryLanguages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categoryLanguages = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
 		return categoryLanguages;
	
	}

	@Override
	public CategoryLanguages findCategoryLanguage(String languageID, int categoryID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		CategoryLanguages categoryLanguages=new CategoryLanguages();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select cl from CategoryLanguages cl " + 
			"where languageID = :languageID and categoryID = :categoryID");
			query.setParameter("languageID",languageID);
			query.setParameter("categoryID",categoryID);
			categoryLanguages = (CategoryLanguages) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categoryLanguages = null;
		} finally {
			session.flush();
			session.close();
		}
 		return categoryLanguages;
	}

	@Override
	public List<CategoryLanguages> findCategoryLanguage(String languageID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<CategoryLanguages> categoryLanguages = new ArrayList<CategoryLanguages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select cl from CategoryLanguages cl where languageID = :languageID");
			query.setParameter("languageID",languageID);
			categoryLanguages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categoryLanguages = null;
		} finally {
			session.flush();
			session.close();
		}
 		return categoryLanguages ;
	}
	@Override
	public void deleteCategoryLanguages(CategoryLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete CategoryLanguages pl where id = :id").setParameter("id", id);
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
	public void updateCategoryLanguages(CategoryLanguages categoryLanguages, CategoryLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update CategoryLanguages pls set name=:name, "
					
					+ "where id = :id");
			query.setParameter("name",categoryLanguages.getName());
			
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
	public void addCategoryLanguages(CategoryLanguages categoryLanguages) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(categoryLanguages);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			categoryLanguages = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
		
	}



	@Override
	public boolean isDuplicate(CategoryLanguagesId id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		CategoryLanguages categoryLanguages=new CategoryLanguages();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select pl from CategoryLanguages pl " + 
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


}
