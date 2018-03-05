package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("languageService")
@Transactional
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguagesDAO languageDAO;
	
	@Override
	public List<Languages> findAll() {
		return languageDAO.findAll();
	}

	@Override
	public Languages findLanguage(String id) {
		// TODO Auto-generated method stub
		return languageDAO.findLanguage(id);
	}
	@Override
	public void deleteLanguage(String id) {
		languageDAO.deleteLanguage(id);
		
	}

	@Override
	public void addLanguage(Languages languages) {
		languageDAO.addLanguage(languages);
		
	}

	@Override
	public void editLanguage(Languages languages, String id) {
		languageDAO.updateLanguage(languages, id);
		
	}


}
