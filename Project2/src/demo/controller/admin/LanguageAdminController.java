package demo.controller.admin;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.CategoryService;
import demo.services.ProductService;
import demo.services.LanguageService;
@Controller
@RequestMapping("admin/language")
public class LanguageAdminController {
	@Autowired
	private LanguageService languageService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
	
		modelMap.put("languages", languageService.findAll());
		return "admin.language.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("languages") Languages languages,ModelMap modelMap) {
		
		
		//modelMap.put("categories", new );
		return "admin.language.register";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,@Valid Languages languages,BindingResult bindingResult) throws ParseException {
		//categoryService;
		if (bindingResult.hasErrors()){
			return "admin.language.register";		
		}
		languageService.addLanguage(languages);
	    return "redirect:/admin/language.html";
	}
	
	@RequestMapping(value = "/delete/{languageId}", method = RequestMethod.GET)
	public String delete(@PathVariable("languageId") String languageId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		languageService.deleteLanguage(languageId);
		modelMap.put("languages", languageService.findAll());
	    return "redirect:/admin/language.html";
	}
	
	@RequestMapping(value = "/detail/{languageId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("languages") Languages languages, ModelMap modelMap,
			@PathVariable("languageId") String languageId) {
		modelMap.put("languages", languageService.findLanguage(languageId));
		//languages.setId(78);
		//languages.setName("gfgfgf");
		//modelMap.put("languageId", languageId);
	    return "admin.language.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{languageId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("languages") @Valid Languages languages,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("languageId") String languageId) throws ParseException {
		if (bindingResult.hasErrors()){
			return "admin.language.detail";		
		}
		languages.setId(languageId);
		languageService.editLanguage(languages,languageId);
		modelMap.put("languages", languageService.findAll());
	    return "redirect:/admin/language.html";
	}
	
}
