package demo.dao;

import java.util.*;

import demo.entities.*;

public interface CategoryDAO {

	public List<Categories> findAll();
	public void deleteCategory(int id);
	public void updateCategory(Categories categories, int id);
	public void addCategory(Categories categories);
	public Categories findCategory(int id);
}
