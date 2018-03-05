package demo.dao;

import demo.entities.*;
import demo.services.AccountService;

import java.util.*;

public interface AccountDAO {

	public List<Accounts> findAll();
	public void deleteAccount(int id);
	public void updateAccount(Accounts accounts, int id);
	public void addAccount(Accounts accounts);
	public Accounts findAccount(int id);
	public boolean IsValid(String userName, String password);
	public Accounts findAccount(String userName, String password);
	public boolean IsValid(String userName);
	public Accounts findAccount(String userName);
}
