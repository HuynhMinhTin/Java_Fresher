package demo.services;

import java.util.*;

import demo.entities.*;

public interface RoleService {

	public List<Roles> findAll();
	public void deleteRole(int id);
	public void addRole(Roles roles);
	public void editRole(Roles roles,int id);
	public Roles findById (int id);
}
