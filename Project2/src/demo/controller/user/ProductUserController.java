package demo.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.ModelMap;

import demo.entities.Languages;
import demo.entities.ProductLanguages;
import demo.entities.*;
import demo.model.*;

import demo.model.ProductModel;
import demo.services.AccountService;
import demo.services.LanguageService;
import demo.services.ProductLanguageService;
import demo.services.ProductService;

@Controller
@RequestMapping("user/product")

public class ProductUserController {
	@Autowired
	private ProductService productService;
	@Autowired
	ProductLanguageService productLanguageService;
	@Autowired
	LanguageService languageService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap,HttpSession session) {
		ProductModel productModel=new ProductModel();
		//session.removeAttribute("account");
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Languages languages=languageService.findLanguage(langCode);
		//List<ProductLanguages> productbyLanguages=productLanguageService.findProductByLanguage(languages.getId());
		//ProductLanguages product1=productLanguageService.findById("vn", 5);
		//System.out.println(product1.getName());
		modelMap.put("products", productLanguageService.findProductByLanguage(languages.getId()));
		//System.out.println(session.getAttribute("account"));
		//modelMap.put("products", productService.findAll());
		return "user.product.index";
	}
	@RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("products") Products products, ModelMap modelMap,
			@PathVariable("productId") Integer productId,HttpSession session) {
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Languages languages=languageService.findLanguage(langCode);
		ProductLanguages product1=productLanguageService.findById(langCode, productId);
		modelMap.put("product1", product1);
		//modelMap.put("products", productService.findById(productId));
		modelMap.put("producttId", productId);
		
		
	    return "user.product.detail";
	}
	@RequestMapping(value = "/findByCategory/{categoryId}", method = RequestMethod.GET)
	public String findbyCategory(ModelMap modelMap,HttpSession session,
			@PathVariable("categoryId") Integer categoryId) {
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Languages languages=languageService.findLanguage(langCode);
		
		modelMap.put("products", productLanguageService.findByCategory(languages.getId(), categoryId));
		
		return "user.product.index";
	}
}