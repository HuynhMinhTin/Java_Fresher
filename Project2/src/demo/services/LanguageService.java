package demo.services;

import java.util.*;

import demo.entities.*;

public interface LanguageService {

	public List<Languages> findAll();
	public void deleteLanguage(String id);
	public void addLanguage(Languages languages);
	public void editLanguage(Languages languages,String id);
	public Languages findLanguage (String id);
	
}