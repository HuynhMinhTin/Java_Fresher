package demo.dao;

import demo.entities.*;
import demo.services.AccountService;

import java.util.*;

public interface LanguagesDAO {

	public List<Languages> findAll();

	public Languages findLanguage(String id);
	public void deleteLanguage(String id);
	public void updateLanguage(Languages languages, String id);
	public void addLanguage(Languages languages);
}
