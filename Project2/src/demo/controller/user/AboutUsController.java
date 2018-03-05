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
@RequestMapping("user/aboutus")
public class AboutUsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "aboutus");
		modelMap.put("action", "aboutus");
		return "user.product.index";
	}
	
}