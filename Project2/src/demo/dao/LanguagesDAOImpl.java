package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("languageDAO")
public class LanguagesDAOImpl implements LanguagesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Languages> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Languages> languages = new ArrayList<Languages>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select l from Languages l");
			languages  = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			languages  = null;
		} finally {
			session.flush();
			session.close();
		}
 		return languages ;
	}

	

	@Override
	public Languages findLanguage(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Languages languages=new Languages();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select l from Languages l " + 
			"where id = :id");
			query.setParameter("id",id);
			languages = (Languages) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			languages  = null;
		} finally {
			session.flush();
			session.close();
		}
 		return languages ;
	}
	@Override
	public void deleteLanguage(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Languages r where id = :id").setParameter("id", id);
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
	public void updateLanguage(Languages languages, String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Languages r set name=:name,"
					+ "id=:id1 "
					+ "where id=:id");
			query.setParameter("name",languages.getName());
			query.setParameter("id1",languages.getId());
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
	public void addLanguage(Languages languages) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(languages);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			languages = null;
		} finally {
			session.flush();
			session.close();
		}
		
	}
	
	
}
