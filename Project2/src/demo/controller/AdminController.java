package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import demo.services.ProductService;


@Controller
@RequestMapping(value="/admin**")
public class AdminController {
	@Autowired
	private ProductService productService;
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap modelMap){
		//modelMap.addAttribute("msg","This is Admin Page");
		//modelMap.put("products", productService.findAll());
		return "admin.product.index";
	}
	

}
