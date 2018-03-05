/*package demo.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import demo.entities2.*;
import demo.model.*;

import demo.model.ProductModel;
import demo.services.AccountService;
import demo.services.ProductService;

@Controller
@RequestMapping("user/product")
public class ProductUserController2 {
	@Autowired
	private ProductService productService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap,HttpSession session) {
		ProductModel productModel=new ProductModel();
		modelMap.put("products", productService.findAll());
		return "user.product.index";
	}
	@RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("products") Products products, ModelMap modelMap,
			@PathVariable("productId") Integer productId,HttpSession session) {
		modelMap.put("products", productService.findById(productId));
		modelMap.put("producttId", productId);
		
		
	    return "user.product.detail";
	}
}*/