package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Products> findAll() {
		return productDAO.findAll();
	}
	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}
	@Override
	public void addProduct(Products products) {
		productDAO.addProduct(products);
	
		
	}
	@Override
	public void editProduct(Products products, int id) {
		
		productDAO.updateProduct(products, id);
		
	}
		
	
	@Override
	public Products findById(int id) {
		// TODO Auto-generated method stub
		return productDAO.findProduct(id);
	}
	@Override
	public List<Products> findByCategory(int id) {
		// TODO Auto-generated method stub
		return productDAO.findByCategory(id);
	}
}
