package demo.controller.user;

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
@RequestMapping("user/home")
public class HomeUserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "home");
		modelMap.put("action", "home");
		return "user.product.index";
	}
	
}