package demo.report;
import demo.entities.*;
import demo.services.ProductService;
import demo.model.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductReport {
	
	public List<Map<String,?>> searchAll(){
		List<Map<String,?>> listProducts=new ArrayList<Map<String,?>>();
		//Map<String,?> product1;
		ProductModel productModel=new ProductModel();
		//List<Products> products=productService.findAll();
		
		//List<Products> products=productModel.findAll();
		for(Products product:productModel.findAll()){
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("id", product.getId());
			m.put("name", product.getName());
			//m.put("price", product.getPrice());
			listProducts.add(m);
		}
		System.out.println(listProducts.size());
		//Map<String,Object> m=new HashMap<String,Object>();
		//m.put("id", "1");
		//m.put("name", "product 1");
		//m.put("price", 100);
		//listProducts.add(m);
		return listProducts;
	}
}
