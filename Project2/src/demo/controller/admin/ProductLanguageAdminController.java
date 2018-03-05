package demo.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;

import demo.model.ProductModel;
import demo.services.AccountService;
import demo.services.CategoryService;
import demo.services.LanguageService;
import demo.services.ProductLanguageService;
import demo.services.ProductService;

@Controller
@RequestMapping("admin/productlanguages")
public class ProductLanguageAdminController implements ServletContextAware {
	private ServletContext servletContext;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductLanguageService productlanguageService;
	@Autowired
	private LanguageService languageService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		modelMap.put("pls", productlanguageService.findAll());
		
		return "admin.productlanguages.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap modelMap,@ModelAttribute("pls") ProductLanguages pls) {
		
		
		//modelMap.put("categories", new );
		modelMap.put("language", languageService.findAll());
		modelMap.put("product", productService.findAll());
		//modelMap.addAttribute("error123", "no dupe");
		return "admin.productlanguages.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,
			@ModelAttribute("pls") @Valid ProductLanguages pls,BindingResult bindingResult) 
					throws ParseException {
			//pls.setLanguages(languages);
		System.out.println(pls.getLanguages().getId());
		System.out.println(pls.getProducts().getId());
		pls.setTitle("title");
		pls.setId(new ProductLanguagesId(pls.getLanguages().getId(), pls.getProducts().getId()));
		if(productlanguageService.isDuplicate(pls.getLanguages().getId(), pls.getProducts().getId())){
			modelMap.addAttribute("error", "Language/Product combination is already existed");
			modelMap.put("language", languageService.findAll());
			modelMap.put("product", productService.findAll());
			return "admin.productlanguages.register";
		}
		productlanguageService.addProductLanguages(pls);
		return "redirect:/admin/productlanguages.html";	
	}
	
	@RequestMapping(value = "/delete/languageId={languageId}&productId={productId}", method = RequestMethod.GET)
	public String delete(@PathVariable("languageId") String languageId,
			@PathVariable("productId") Integer productId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		productlanguageService.deleteProductLanguages(languageId, productId);
		modelMap.put("pls", productlanguageService.findAll());
	    return "redirect:/admin/productlanguages.html";
	}
	@RequestMapping(value = "/productlanguagesdetail/languageId={languageId}&productId={productId}", method = RequestMethod.GET)
	public String detail_PL(@ModelAttribute("pls") ProductLanguages pls
			, ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("productId") Integer productID) {
		modelMap.put("pls", productlanguageService.findById(languageID, productID));
		modelMap.put("language", languageService.findAll());
		modelMap.put("product", productService.findAll());
	    return "admin.productlanguages.productlanguagesdetail";
	}
	@RequestMapping(value = "/detail/languageId={languageId}&productId={productId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("pls") ProductLanguages pls
			, ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("productId") Integer productID) {
		modelMap.put("pls", productlanguageService.findById(languageID, productID));
		modelMap.put("language", languageService.findAll());
		modelMap.put("product", productService.findAll());
	    return "admin.productlanguages.detail";
	}

	
	@RequestMapping(value = "/detail/edit/languageId={languageId}&productId={productId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("pls") ProductLanguages pls,
			ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("productId") Integer productID) throws ParseException {
			
		productlanguageService.editProductLanguages(pls, languageID, productID);
		return "redirect:/admin/productlanguages.html";	
	}
	private String saveImage(MultipartFile image) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/user/images/" + image.getOriginalFilename());
			System.out.println(file.getAbsolutePath());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return image.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}
	private boolean validateImage(MultipartFile image) {
		return image.getContentType().equals("image/jpeg") || image.getContentType().equals("image/jpg")
				|| image.getContentType().equals("image/gif") || image.getContentType().equals("image/png");
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
		
}
