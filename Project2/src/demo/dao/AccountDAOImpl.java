package demo.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import demo.entities.*;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Accounts> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Accounts> accounts = new ArrayList<Accounts>();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a");
			accounts = query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			accounts = null;
		} finally {
			session.flush();
			session.close();
		}
 		return accounts;
	}

	@Override
	public void deleteAccount(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Accounts a where id = :id").setParameter("id", id);
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
	public void updateAccount(Accounts accounts, int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
	
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Accounts a set "
					+ "userNames=:userNames, "
					+ "passwords=:passwords, "
					+"score=:score "
					+ "where id = :id");
			query.setParameter("userNames",accounts.getUserNames());
			query.setParameter("passwords",accounts.getPasswords());
			query.setParameter("score",accounts.getScore());
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
	public void addAccount(Accounts accounts) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
 		try {
 			
			transaction = session.beginTransaction();
			session.createSQLQuery("SET IDENTITY_INSERT Accounts ON").executeUpdate(); 
			session.save(accounts);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			accounts = null;
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public Accounts findAccount(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Accounts accounts=new Accounts();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a " + 
			"where id = :id");
			query.setParameter("id",id);
			accounts = (Accounts) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			accounts = null;
		} finally {
			session.flush();
			session.close();
		}
 		return accounts;
	}

	@Override
	public boolean IsValid(String userName, String password) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Accounts accounts=new Accounts();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a " + 
			"where userNames = :userNames and passwords = :passwords and roles.name = :roles");
			query.setParameter("userNames",userName);
			query.setParameter("passwords",password);
			query.setParameter("roles","ROLE_USER");
			if(query.uniqueResult()!=null){
				return true;
			}
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			accounts = null;
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Override
	public Accounts findAccount(String userName, String password) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a " + 
			"where userNames = :userNames and passwords = :passwords and roles.name = :roles");
			query.setParameter("userNames",userName);
			query.setParameter("passwords",password);
			query.setParameter("roles","ROLE_USER");
			return (Accounts) query.uniqueResult();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			return  null;
		} finally {
			session.flush();
			session.close();
		}
	}

	
	@Override
	public boolean IsValid(String userName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Accounts accounts=new Accounts();
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a " + 
			"where userNames = :userNames  and roles.name = :roles");
			query.setParameter("userNames",userName);
			query.setParameter("roles","ROLE_USER");
			if(query.uniqueResult()!=null){
				return true;
			}
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			accounts = null;
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Override
	public Accounts findAccount(String userName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
 		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("select a from Accounts a " + 
			"where userNames = :userNames");
			query.setParameter("userNames",userName);
			
			query.setParameter("roles","ROLE_USER");
			return (Accounts) query.uniqueResult();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			return  null;
		} finally {
			session.flush();
			session.close();
		}
	}
}
