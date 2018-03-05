package demo.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.entities.Accounts;
import demo.services.AccountService;
import demo.services.OrderDetailService;
import demo.services.OrderService;
import demo.services.ProductService;
//@SessionAttributes("account1")
@Controller
@RequestMapping("user/information")

public class UserInformationController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private AccountService accountService;
	@RequestMapping(method = RequestMethod.GET)
	
	
	public String index(@ModelAttribute("accounts") Accounts accounts,
			HttpSession session,HttpServletRequest request,ModelMap modelMap	) {
		//session=request.getSession();
		//if(account1!=null){
		
			//session.setAttribute("account1", account1);
		//}
		//accounts=(Accounts) session.getAttribute("account1");
		//System.out.println(accounts.toString());
		//request.getAttribute("account");
		//if(accounts==null){
		//	return "user.login.index";
		
		//System.out.println(request.getAttribute("account1"));
		//}
		//System.out.println(session.getAttribute("account"));
		accounts=(Accounts) session.getAttribute("account");
		modelMap.put("accounts", accounts);
		
		return "user.information.index";
	}
	// @ModelAttribute("account1")
	   // public Accounts getAccounts (HttpSession session) {
	  //      return (Accounts) session.getAttribute("account1");
	  //  }
}
