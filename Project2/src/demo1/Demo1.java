package demo1;
import java.math.BigDecimal;
import java.util.*;

import demo.entities.*;
import demo.model.*;
import demo.services.CategoryService;
public class Demo1 {
	 public static void main(String[] args) {
		
		CategoryLanguagesModel categoryLanguagesModel=new CategoryLanguagesModel();
		ProductModel productModel=new ProductModel();
		for(CategoryLanguages cl:categoryLanguagesModel.findAll()){
			System.out.println(cl.getName());
		}
		//for(Products p:productModel.findAll()){
		//	System.out.println(p.getName());
		//}
	}
}
