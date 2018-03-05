package demo.dao;

import java.util.*;

import demo.entities.*;

public interface ProductDAO {

	public List<Products> findAll();
	public void deleteProduct(int id);
	public void updateProduct(Products products, int id);
	public void addProduct(Products products);
	public Products findProduct(int id);
	public List<Products> findByCategory(int id);
}
