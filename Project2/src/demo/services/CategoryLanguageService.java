package demo.services;

import java.util.List;

import demo.entities.*;

public interface CategoryLanguageService {
	public List<CategoryLanguages> findAll();;
	public CategoryLanguages findById (String languageID,int categoryID);
	public List<CategoryLanguages> findCategoryByLanguage(String languageID);
	public void deleteCategoryLanguages(String languageId, int categoryId);
	public void addCategoryLanguages(CategoryLanguages categoryLanguages);
	public void editCategoryLanguages(CategoryLanguages categoryLanguages,String languageId, int categoryId);
	public boolean isDuplicate(String languageId, int categoryId);
}
