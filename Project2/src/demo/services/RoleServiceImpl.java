package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public List<Roles> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public void deleteRole(int id) {
		roleDAO.deleteRole(id);
		
	}

	@Override
	public void addRole(Roles roles) {
		roleDAO.addRole(roles);
		
	}

	@Override
	public void editRole(Roles roles, int id) {
		roleDAO.updateRole(roles, id);
		
	}

	@Override
	public Roles findById(int id) {
		// TODO Auto-generated method stub
		return roleDAO.findRole(id);
	};

}
