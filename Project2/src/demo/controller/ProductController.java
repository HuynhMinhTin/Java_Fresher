package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.*;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.*;

import java.util.*;

import demo.services.*;

@Controller
@RequestMapping(value = "products")
public class ProductController {
	@Autowired
	LanguageService languageService;
	@Autowired
	ProductLanguageService productLanguageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Languages languages=languageService.findLanguage(langCode);
		List<ProductLanguages> productbyLanguages=productLanguageService.findProductByLanguage(languages.getId());
		ProductLanguages product1=productLanguageService.findById("vn", 5);
		System.out.println(product1.getName());
		return "multiplelanguage";
	}

}
