package demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import demo.services.ProductService;


@Controller
@RequestMapping(value="paypal")
public class PayPalController {
	@Autowired
	private ProductService productService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "admin.product.index";
	}
	@RequestMapping(value="success",method = RequestMethod.GET)
	public String success(ModelMap modelMap,HttpServletRequest request){
		PayPalSuccess ps=new PayPalSuccess();
		modelMap.put("result", ps.getPayPal(request));
		return "sucess";
	}

}
