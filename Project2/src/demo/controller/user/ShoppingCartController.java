package demo.controller.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.services.AccountService;
import demo.services.LanguageService;
import demo.services.OrderDetailService;
import demo.services.OrderService;
import demo.services.ProductLanguageService;
import demo.services.ProductService;
import demo.validator.OrderValidator;
import demo.entities.*;
import demo.model.RoleModel;
@Controller
@RequestMapping("user/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private ProductLanguageService productlanguageService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("listProducts",productService.findAll());
		return "user.shoppingcart.index";
	}
	@RequestMapping(value = "/ordernow/{id}", method = RequestMethod.GET)
	public String ordernow(@PathVariable(value="id") Integer id,ModelMap modelMap,
			HttpSession session) {
		String langCode = LocaleContextHolder.getLocale().getLanguage();
		Languages languages=languageService.findLanguage(langCode);
		if (session.getAttribute("cart")==null) {
			List<Item> cart=new ArrayList<Item>();
			cart.add(new Item(productlanguageService.findById(languages.getId(),productService.findById(id).getId() ),1));
			session.setAttribute("cart", cart);
			
		}
		else{
			List<Item> cart=(List<Item>) session.getAttribute("cart");
			int index=isExist(id, session);
			if (index==-1) {
				cart.add(new Item(productlanguageService.findById(languages.getId(),productService.findById(id).getId() ),1));
			} else {
				int quantity=cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
			
		}
		return "user.shoppingcart.cart";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value="id") Integer id,ModelMap modelMap,

			HttpSession session) {
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		int index=isExist(id, session);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "user.shoppingcart.cart";
		
	}
	
	private int isExist(int id,HttpSession session){
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		for(int i=0;i<cart.size();i++){
			if(cart.get(i).getProductLanguages().getProducts().getId()==id){
				return i;
			}
		}
		return -1;	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpSession session) {
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		String []quantity=request.getParameterValues("quantity");
		
		for(int i=0;i<cart.size();i++){
			cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
		}
		session.setAttribute("cart", cart);
		return "user.shoppingcart.cart";
		
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(ModelMap modelMap,@ModelAttribute("order") @Valid Orders order,BindingResult bindingResult,HttpSession session) {
		//session.setAttribute("cart", cart);
		return "user.shoppingcart.checkout";
	}
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public String saveOrder(HttpSession session,HttpServletRequest request,
			ModelMap modelMap,@ModelAttribute("order") @Valid Orders order,BindingResult bindingResult) {
		
		if (!accountService.isValid(order.getAccounts().getUserNames(), order.getAccounts().getPasswords())){
			modelMap.addAttribute("error1","Username or password is not correct");
			return "user.shoppingcart.checkout";
		}
		order.setOrderDate(new Date());
		OrderValidator orderValidator=new OrderValidator();
		orderValidator.validate(order, bindingResult);
		if (bindingResult.hasErrors()){
			//System.out.println(bindingResult.toString());
			
			return "user.shoppingcart.checkout";
		}
		session.setAttribute("account",accountService.findUsername(
				order.getAccounts().getUserNames(), order.getAccounts().getPasswords()));
		Accounts account1=(Accounts) session.getAttribute("account");
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		
		//Orders orders=new Orders();
		order.setOrderDate(new Date());
		System.out.println(order.getOrderDate());
	
		
		order.setAccounts(account1);
		//System.out.println(accounts.getId());
		orderService.addOrder(order);
		
		for(int i=0;i<cart.size();i++){
			OrderDetails orderDetails=new OrderDetails();
			orderDetails.setId(new OrderDetailsId(order.getId(),cart.get(i).getProductLanguages().getProducts().getId()));
			orderDetails.setPrice(cart.get(i).getProductLanguages().getProducts().getPrice());
			orderDetails.setQuanity(cart.get(i).getQuantity());
			//System.out.println("Product ID:"+cart.get(i).getProduct().getId());
			//System.out.println("Order ID:"+order.getId());
			orderDetailService.addOrderDetail(orderDetails);
		}
		session.setAttribute("cart", cart);
		return "user.shoppingcart.success";
	}
	@RequestMapping(value = "/checklist", method = RequestMethod.GET)
	public String checklist(ModelMap modelMap,
			HttpSession session) {
		
		if (session.getAttribute("cart")==null) {
			List<Item> cart=new ArrayList<Item>();
			//cart.add(new Item(productService.findById(id),1));
			session.setAttribute("cart", cart);
			
		}
		else{
			List<Item> cart=(List<Item>) session.getAttribute("cart");

			session.setAttribute("cart", cart);
			
		}
		return "user.shoppingcart.cart";
	}
}
