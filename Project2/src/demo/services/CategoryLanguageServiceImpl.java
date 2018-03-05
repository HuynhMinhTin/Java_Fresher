package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.CategoryLanguageDAO;
import demo.dao.CategoryDAO;
import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguagesId;

@Service("categorylanguageService")
public class CategoryLanguageServiceImpl implements CategoryLanguageService{

	@Autowired
	private CategoryLanguageDAO categoryLanguagesDAO;
	@Override
	public List<CategoryLanguages> findAll() {
		// TODO Auto-generated method stub
		return categoryLanguagesDAO.findAll();
	}

	@Override
	public CategoryLanguages findById(String languageID, int categoryID) {
		// TODO Auto-generated method stub
		return categoryLanguagesDAO.findCategoryLanguage(languageID, categoryID);
	}

	@Override
	public List<CategoryLanguages> findCategoryByLanguage(String languageID) {
		// TODO Auto-generated method stub
		return categoryLanguagesDAO.findCategoryLanguage(languageID);
	}
	
	@Override
	public void deleteCategoryLanguages(String languageId, int categoryId) {
		CategoryLanguagesId id=new CategoryLanguagesId(languageId, categoryId);
		categoryLanguagesDAO.deleteCategoryLanguages(id);
		
	}

	@Override
	public void addCategoryLanguages(CategoryLanguages categoryLanguages) {
		categoryLanguagesDAO.addCategoryLanguages(categoryLanguages);
		
	}

	@Override
	public void editCategoryLanguages(CategoryLanguages categoryLanguages, String languageId, int categoryId) {
		CategoryLanguagesId id=new CategoryLanguagesId(languageId, categoryId);
		categoryLanguagesDAO.updateCategoryLanguages(categoryLanguages, id);
	}

	@Override
	public boolean isDuplicate(String languageId, int categoryId) {
		CategoryLanguagesId id=new CategoryLanguagesId(languageId, categoryId);
		return categoryLanguagesDAO.isDuplicate(id);
	}

}
