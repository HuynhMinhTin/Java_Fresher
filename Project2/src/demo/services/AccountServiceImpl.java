package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public List<Accounts> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public void deleteAccount(int id) {
		accountDAO.deleteAccount(id);
		
	}

	@Override
	public void addAccount(Accounts accounts) {
		accountDAO.addAccount(accounts);
		
	}

	@Override
	public void editAccount(Accounts accounts, int id) {
		accountDAO.updateAccount(accounts, id);
		
	}

	@Override
	public Accounts findById(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findAccount(id);
	
	}

	@Override
	public boolean isValid(String userName, String password) {
		// TODO Auto-generated method stub
		return accountDAO.IsValid(userName, password);
	}

	@Override
	public Accounts findUsername(String userName, String password) {
		// TODO Auto-generated method stub
		return accountDAO.findAccount(userName, password);
	}
	@Override
	public boolean isValid(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.IsValid(userName);
	}

	@Override
	public Accounts findUsername(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.findAccount(userName);
	}
}
