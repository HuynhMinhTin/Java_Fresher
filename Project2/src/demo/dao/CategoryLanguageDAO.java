package demo.dao;

import java.util.List;

import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguages;
import demo.entities.CategoryLanguagesId;


public interface  CategoryLanguageDAO {
	public List<CategoryLanguages> findAll();
	public CategoryLanguages findCategoryLanguage(String languageID,int categoryID);
	public List<CategoryLanguages> findCategoryLanguage(String languageID);
	public void deleteCategoryLanguages(CategoryLanguagesId id);
	public void updateCategoryLanguages(CategoryLanguages categoryLanguages, CategoryLanguagesId id);
	public void addCategoryLanguages(CategoryLanguages categoryLanguages);
	public boolean isDuplicate(CategoryLanguagesId id);
}
