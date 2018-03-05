package demo.dao;

import java.util.*;

import demo.entities.*;

public interface RoleDAO {

	public List<Roles> findAll();
	public void deleteRole(int id);
	public void updateRole(Roles roles, int id);
	public void addRole(Roles roles);
	public Roles findRole(int id);
	
}
