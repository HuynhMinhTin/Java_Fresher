package demo.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import demo.entities2.*;
import demo.model.*;

import demo.model.ProductModel;
import demo.services.AccountService;
import demo.services.CategoryService;
import demo.services.ProductService;

@Controller
@RequestMapping("user/category")
public class CategoryUserController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		
		modelMap.put("categories", categoryService.findAll());
		return "user.category.index";
	}
}