package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Roles> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Roles> Roles = new ArrayList<Roles>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select c from Roles c");
			Roles = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			Roles = null;
		} finally {
			session.flush();
			session.close();
		}
 		return Roles;
	}

	@Override
	public void deleteRole(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Roles r where id = :id").setParameter("id", id);
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
	public void updateRole(Roles roles, int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Roles r set name=:name,"
					+ "id=:id1 "
					+ "where id=:id");
			query.setParameter("name",roles.getName());
			query.setParameter("id1",roles.getId());
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
	public void addRole(Roles roles) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
			transaction = session.beginTransaction();
			session.save(roles);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			roles = null;
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public Roles findRole(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Roles roles=new Roles();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select r from Roles r " + 
			"where id=:id");
			query.setParameter("id",id);
			roles = (Roles) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			roles = null;
		} finally {
			session.flush();
			session.close();
		}
 		return roles;
	}

	
	
}
