package demo.services;

import java.util.*;

import demo.entities.*;

public interface AccountService {

	public List<Accounts> findAll();
	public void deleteAccount(int id);
	public void addAccount(Accounts accounts);
	public void editAccount(Accounts accounts,int id);
	public Accounts findById (int id);
	public boolean isValid (String userName,String password);
	public Accounts findUsername (String userName,String password);
	public boolean isValid (String userName);
	public Accounts findUsername (String userName);
}
