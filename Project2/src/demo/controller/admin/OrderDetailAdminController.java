package demo.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.*;
import demo.validator.OrderDetailValidator;
import demo.validator.OrderValidator;
@Controller
@RequestMapping("admin/orderdetail")
public class OrderDetailAdminController {
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		OrderDetailModel orderDetailModel=new OrderDetailModel();
		modelMap.put("orderdetails", orderDetailService.findAll());
		return "admin.orderdetail.index";
	}
	@RequestMapping(value = "/delete/{productId}&{orderId}", method = RequestMethod.GET)
	public String delete(@PathVariable("productId") Integer productId,
			@PathVariable("orderId") Integer orderId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		orderDetailService.deleteOrderDetail(productId, orderId);
		modelMap.put("orders", orderDetailService.findAll());
	    return "redirect:/admin/orderdetail.html";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("orderdetails") OrderDetails orderdetails,ModelMap modelMap) throws ParseException {
		
		modelMap.put("products", productService.findAll());
		modelMap.put("orders", orderService.findAll());
		return "admin.orderdetail.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("orderdetails") @Valid OrderDetails orderDetails,BindingResult bindingResult,
			ModelMap modelMap) {
		OrderDetailValidator orderdetailValidator=new OrderDetailValidator();
		orderdetailValidator.validate(orderDetails, bindingResult);
	
		if (bindingResult.hasErrors()){
			//System.out.println("error");
			modelMap.put("products", productService.findAll());
			modelMap.put("orders", orderService.findAll());
			return "admin.orderdetail.register";
		
			
		}
		else{
			orderDetailService.addOrderDetail(orderDetails);
			return "redirect:/admin/order.html";
		}
	}
	
	@RequestMapping(value = "/detail/{productId}&{orderId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("orderdetails") OrderDetails orderdetails, ModelMap modelMap,
			@PathVariable("productId") Integer productId,
			@PathVariable("orderId") Integer orderId) {
		
		modelMap.put("products", productService.findAll());
		modelMap.put("orders", orderService.findAll());
		modelMap.put("productId", productId);
		modelMap.put("orderId", orderId);
	    return "admin.orderdetail.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{productId}&{orderId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("orderdetails") @Valid OrderDetails orderDetails,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("productId") Integer productId,
			@PathVariable("orderId") Integer orderId) throws ParseException {
		
		OrderDetailValidator orderdetailValidator=new OrderDetailValidator();
		orderdetailValidator.validate(orderDetails, bindingResult);
	
		if (bindingResult.hasErrors()){
			//System.out.println("error");
			modelMap.put("product", productService.findAll());
			modelMap.put("order", orderService.findAll());
			return "redirect:/admin/order/detail/{productId}&{orderId}.html";
		
			
		}
		else{
			orderDetailService.addOrderDetail(orderDetails);
			return "redirect:/admin/order.html";
		}
	}
}
