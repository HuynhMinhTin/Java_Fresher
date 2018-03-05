package demo.services;

import java.util.*;

import demo.entities.*;

public interface CategoryService {

	public List<Categories> findAll();
	public void deleteCategory(int id);
	public void addCategory(Categories categories);
	public void editCategory(Categories categories,int id);
	public Categories findById (int id);
}
