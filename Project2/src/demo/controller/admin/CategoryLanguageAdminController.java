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

import demo.model.CategoryModel;
import demo.services.AccountService;
import demo.services.CategoryService;
import demo.services.LanguageService;
import demo.services.CategoryLanguageService;
import demo.services.CategoryService;

@Controller
@RequestMapping("admin/categorylanguages")
public class CategoryLanguageAdminController  {
	private ServletContext servletContext;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryLanguageService categorylanguageService;
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
		
		modelMap.put("cls", categorylanguageService.findAll());
		
		return "admin.categorylanguages.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap modelMap,@ModelAttribute("cls") CategoryLanguages cls) {
		
		
		//modelMap.put("categories", new );
		modelMap.put("language", languageService.findAll());
		modelMap.put("category", categoryService.findAll());
		//modelMap.addAttribute("error123", "no dupe");
		return "admin.categorylanguages.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,
			@ModelAttribute("cls") @Valid CategoryLanguages cls,BindingResult bindingResult) 
					throws ParseException {
			//cls.setLanguages(languages);
		System.out.println(cls.getLanguages().getId());
		System.out.println(cls.getCategories().getId());
		
		cls.setId(new CategoryLanguagesId(cls.getLanguages().getId(), cls.getCategories().getId()));
		if(categorylanguageService.isDuplicate(cls.getLanguages().getId(), cls.getCategories().getId())){
			modelMap.addAttribute("error", "Language/Category combination is already existed");
			modelMap.put("language", languageService.findAll());
			modelMap.put("category", categoryService.findAll());
			return "admin.categorylanguages.register";
		}
		categorylanguageService.addCategoryLanguages(cls);
		return "redirect:/admin/categorylanguages.html";	
	}
	
	@RequestMapping(value = "/delete/languageId={languageId}&categoryId={categoryId}", method = RequestMethod.GET)
	public String delete(@PathVariable("languageId") String languageId,
			@PathVariable("categoryId") Integer categoryId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		categorylanguageService.deleteCategoryLanguages(languageId, categoryId);
		modelMap.put("cls", categorylanguageService.findAll());
	    return "redirect:/admin/categorylanguages.html";
	}
	@RequestMapping(value = "/categorylanguagesdetail/languageId={languageId}&categoryId={categoryId}", method = RequestMethod.GET)
	public String detail_PL(@ModelAttribute("cls") CategoryLanguages cls
			, ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("categoryId") Integer categoryID) {
		modelMap.put("cls", categorylanguageService.findById(languageID, categoryID));
		modelMap.put("language", languageService.findAll());
		modelMap.put("category", categoryService.findAll());
	    return "admin.categorylanguages.categorylanguagesdetail";
	}
	@RequestMapping(value = "/detail/languageId={languageId}&categoryId={categoryId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cls") CategoryLanguages cls
			, ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("categoryId") Integer categoryID) {
		modelMap.put("cls", categorylanguageService.findById(languageID, categoryID));
		modelMap.put("language", languageService.findAll());
		modelMap.put("category", categoryService.findAll());
	    return "admin.categorylanguages.detail";
	}

	
	@RequestMapping(value = "/detail/edit/languageId={languageId}&categoryId={categoryId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("cls") CategoryLanguages cls,
			ModelMap modelMap,
			@PathVariable("languageId") String languageID,@PathVariable("categoryId") Integer categoryID) throws ParseException {
			
		categorylanguageService.editCategoryLanguages(cls, languageID, categoryID);
		return "redirect:/admin/categorylanguages.html";	
	}

	
		
}
