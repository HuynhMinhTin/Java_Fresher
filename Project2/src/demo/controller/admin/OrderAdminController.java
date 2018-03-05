package demo.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.AccountService;
import demo.services.OrderService;
import demo.validator.OrderValidator;
@Controller
@RequestMapping("admin/order")
public class OrderAdminController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		OrderModel orderModel=new OrderModel();
		modelMap.put("orders", orderService.findAll());
		return "admin.order.index";
	}
	
	@RequestMapping(value = "/delete/{orderId}", method = RequestMethod.GET)
	public String delete(@PathVariable("orderId") Integer orderId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		
		
		orderService.deleteOrder(orderId);
		modelMap.put("orders", orderService.findAll());
	    return "redirect:/admin/order.html";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("orders") Orders orders,ModelMap modelMap) throws ParseException {
		
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
		modelMap.put("account", accountService.findAll());
		orders.setOrderDate(dt.parse("1998-01-02 00:00:00.000"));
		return "admin.order.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("orders") @Valid Orders orders,BindingResult bindingResult,ModelMap modelMap) {
		//categoryService;
		OrderValidator orderValidator=new OrderValidator();
		orderValidator.validate(orders, bindingResult);
	
		if (bindingResult.hasErrors()){
			//System.out.println("error");
			modelMap.put("account", accountService.findAll());
			return "admin.order.register";
		}
		else{
			orderService.addOrder(orders);
			return "redirect:/admin/order.html";
		}
		
	}
	
	@RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("orders")@Valid Orders orders,BindingResult bindingResult, ModelMap modelMap,
			@PathVariable("orderId") Integer orderId) {
		modelMap.put("orders", orderService.findById(orderId));
		modelMap.put("account", accountService.findAll());
		modelMap.put("orderId", orderId);
	    return "admin.order.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{orderId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("orders")@Valid Orders orders,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("orderId") Integer orderId) throws ParseException {
		
		OrderValidator orderValidator=new OrderValidator();
		orderValidator.validate(orders, bindingResult);
	
		if (bindingResult.hasErrors()){
			//System.out.println("error");
			modelMap.put("account", accountService.findAll());
			return "redirect:/admin/order/detail/{orderId}.html";
		
			
		}
		else{
			SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
			orders.setOrderDate(dt.parse("1998-01-02 00:00:00.000"));
			orderService.editOrder(orders, orderId);
			
		    return "redirect:/admin/order.html";
		}
	}
	
}
