package demo.services;

import java.util.*;

import demo.entities.*;

public interface ProductLanguageService {

	public List<ProductLanguages> findAll();;
	public ProductLanguages findById (String languageID,int productID);
	public List<ProductLanguages> findProductByLanguage(String languageID);
	public void deleteProductLanguages(String languageId, int productId);
	public void addProductLanguages(ProductLanguages productLanguages);
	public void editProductLanguages(ProductLanguages productLanguages,String languageId, int productId);
	public boolean isDuplicate(String languageId, int productId);
	public List<ProductLanguages> findByCategory(String languageId,int categoryId);
	
}