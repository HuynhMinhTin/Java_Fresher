package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Categories> findAll() {
		return categoryDAO.findAll();
	}
	
	@Override
	public void deleteCategory(int id) {
		categoryDAO.deleteCategory(id);
	}

	@Override
	public void addCategory(Categories categories) {
		categoryDAO.addCategory(categories);
		
	}

	@Override
	public void editCategory(Categories categories,int id) {
		categoryDAO.updateCategory(categories, id);
		
	}

	@Override
	public Categories findById(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.findCategory(id);
	}
}
