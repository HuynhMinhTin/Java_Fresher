package demo.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.CategoryService;
import demo.validator.AccountValidator;
import demo.validator.CategoryValidator;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
@Controller
@RequestMapping("admin/category**")
public class CategoryAdminController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		
		modelMap.put("categories", categoryService.findAll());
		return "admin.category.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("categories") @Valid Categories categories,BindingResult bindingResult
			,ModelMap modelMap) {
		
		//modelMap.put("categories", categoryService.findById(categoryId));
		//modelMap.put("categories", new );
		
			
		return "admin.category.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("categories") @Valid Categories categories,BindingResult bindingResult,ModelMap modelMap) {
		//categoryService;
		
		CategoryValidator categoryValidator=new CategoryValidator();
		categoryValidator.validate(categoryValidator, bindingResult);
		if (bindingResult.hasErrors()){
			return "admin.category.register";
		}
		else{
			categoryService.addCategory(categories);
			return "redirect:/admin/category.html";
		}
	    
	}
	
	
	@RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.GET)
	public String delete(ModelMap modelMap,@PathVariable("categoryId") Integer categoryId) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		categoryService.deleteCategory(categoryId);
		modelMap.put("category", categoryService.findAll());
	    return "redirect:/admin/category.html";
	}
	
	@RequestMapping(value = "/detail/{categoryId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("categories") Categories categories, ModelMap modelMap,
			@PathVariable("categoryId") Integer categoryId) {

		modelMap.put("categories", categoryService.findById(categoryId));
		modelMap.put("categorytId", categoryId);
	    return "admin.category.detail";
		
	}
	
	@RequestMapping(value = "/detail/edit/{categoryId}", method = {RequestMethod.POST,RequestMethod.GET})
	public String edit(@ModelAttribute("categories") @Valid Categories categories,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("categoryId") Integer categoryId) {
		CategoryValidator categoryValidator=new CategoryValidator();
		categoryValidator.validate(categoryValidator, bindingResult);
		if (bindingResult.hasErrors()){
			categoryService.editCategory(categories,categoryId);
	
			return "redirect:/admin/category/detail/{categoryId}.html";
		}
		else{
			categoryService.editCategory(categories,categoryId);
		    return "redirect:/admin/category.html";
		}
		
	}
	
}
