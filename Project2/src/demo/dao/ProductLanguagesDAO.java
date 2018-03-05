package demo.dao;

import demo.entities.*;
import demo.services.AccountService;

import java.util.*;

public interface ProductLanguagesDAO {

	public List<ProductLanguages> findAll();
	public ProductLanguages findProductLanguages(String languageID,int productID);
	public List<ProductLanguages> findProductbyLanguages(String languageID);
	public void deleteProductLanguages(ProductLanguagesId id);
	public void updateProductLanguages(ProductLanguages productLanguages, ProductLanguagesId id);
	public void addProductLanguages(ProductLanguages productLanguages);
	public boolean isDuplicate(ProductLanguagesId id);
	public List<ProductLanguages> findByCategory(String languageID,int categoryId);
}
