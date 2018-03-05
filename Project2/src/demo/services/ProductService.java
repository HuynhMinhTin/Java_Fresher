package demo.services;

import java.util.*;

import demo.entities.*;

public interface ProductService {

	public List<Products> findAll();
	public void deleteProduct(int id);
	public void addProduct(Products products);
	public void editProduct(Products products,int id);
	public Products findById (int id);
	public List<Products > findByCategory(int id);
	
}