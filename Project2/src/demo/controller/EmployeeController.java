package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import demo.entities.Languages;
import demo.model.ProductModel;
import demo.services.LanguageService;
import demo.services.ProductLanguageService;
import demo.services.ProductService;


@Controller
@RequestMapping(value="/employee**")
public class EmployeeController {
	@Autowired
	private ProductService productService;
	@Autowired
	ProductLanguageService productLanguageService;
	@Autowired
	LanguageService languageService;
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap modelMap){
	ProductModel productModel=new ProductModel();
		
		//String langCode = LocaleContextHolder.getLocale().getLanguage();
		//Languages languages=languageService.findLanguage(langCode);
		//List<ProductLanguages> productbyLanguages=productLanguageService.findProductByLanguage(languages.getId());
		//ProductLanguages product1=productLanguageService.findById("vn", 5);
		//System.out.println(product1.getName());
		//modelMap.put("products", productLanguageService.findProductByLanguage(languages.getId()));
		return "user.product.index";
	}
	

}
