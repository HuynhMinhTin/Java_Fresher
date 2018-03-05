package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("feedback1DAO")
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Feedbacks> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Feedbacks> feedbacks = new ArrayList<Feedbacks>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from Feedbacks o");
			feedbacks= query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			feedbacks = null;
		} finally {
			session.flush();
			session.close();
		}
 		return feedbacks;
	}

	@Override
	public void deleteFeedbacks(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Feedbacks o where id = :id").setParameter("id", id);
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
	public void updateFeedbacks(Feedbacks feedbacks, int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Feedbacks fb set subject=:subject, "
					+"message=:message, "
					+"name=:name, "
					+"contactNumber=:contactNumber, "
					+"receivedDate=:receivedDate, "
					+ "where id = :id");
			query.setParameter("subject",feedbacks.getSubject());
			query.setParameter("message=",feedbacks.getMessage());
			query.setParameter("name",feedbacks.getName());
			query.setParameter("contactNumber",feedbacks.getContactNumber());
			query.setParameter("receivedDate",feedbacks.getReceivedDate());
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
	public void addFeedbacks(Feedbacks feedbacks) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(feedbacks);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			feedbacks = null;System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public Feedbacks findFeedbacks(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Feedbacks feedbacks=new Feedbacks();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select o from Feedbacks o " + 
			"where id = :id");
			query.setParameter("id",id);
			feedbacks= (Feedbacks) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			feedbacks = null;
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}
 		return feedbacks;
	}

	
	
}
