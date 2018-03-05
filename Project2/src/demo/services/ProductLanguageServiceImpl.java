package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("productlanguageService")
@Transactional
public class ProductLanguageServiceImpl implements ProductLanguageService {

	@Autowired
	private ProductLanguagesDAO productlanguageDAO;
	
	@Override
	public List<ProductLanguages> findAll() {
		return productlanguageDAO.findAll();
	}

	@Override
	public ProductLanguages findById(String languageID, int productID) {
		// TODO Auto-generated method stub
		return productlanguageDAO.findProductLanguages(languageID, productID);
	}

	@Override
	public List<ProductLanguages> findProductByLanguage(String languageID) {
		// TODO Auto-generated method stub
		return productlanguageDAO.findProductbyLanguages(languageID);
	}

	@Override
	public void deleteProductLanguages(String languageId, int productId) {
		ProductLanguagesId id=new ProductLanguagesId(languageId, productId);
		productlanguageDAO.deleteProductLanguages(id);
		
	}

	@Override
	public void addProductLanguages(ProductLanguages productLanguages) {
		productlanguageDAO.addProductLanguages(productLanguages);
		
	}

	@Override
	public void editProductLanguages(ProductLanguages productLanguages, String languageId, int productId) {
		ProductLanguagesId id=new ProductLanguagesId(languageId, productId);
		productlanguageDAO.updateProductLanguages(productLanguages, id);
	}

	@Override
	public boolean isDuplicate(String languageId, int productId) {
		ProductLanguagesId id=new ProductLanguagesId(languageId, productId);
		return productlanguageDAO.isDuplicate(id);
	}
	@Override
	public List<ProductLanguages> findByCategory(String languageId,int categoryId) {
		// TODO Auto-generated method stub
		return productlanguageDAO.findByCategory(languageId,categoryId);
	}

	
}
