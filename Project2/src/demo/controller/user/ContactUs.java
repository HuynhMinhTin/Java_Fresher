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
@RequestMapping("user/contactus")
public class ContactUs {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "contactus");
		modelMap.put("action", "contactus");
		return "user.product.index";
	}
	
}