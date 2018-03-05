package demo.controller.user;

import java.text.ParseException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.entities.Accounts;
import demo.entities.Roles;
import demo.model.*;
import demo.services.*;
import demo.services.CategoryService;
import demo.validator.AccountValidator;

@Controller
@RequestMapping("user/login")
public class LoginUserController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap, @ModelAttribute("accounts")Accounts accounts){
		accounts.setScore(10);
		accounts.setRoles(roleService.findById(4));
		return "user.login.index";
	}
	
	@RequestMapping(value="/authen",method = RequestMethod.POST)
	public String authen(ModelMap modelMap,@ModelAttribute("accounts")Accounts accounts,
			HttpSession session,HttpServletRequest request,final RedirectAttributes redirectAttrs
			) {
		//return "user.login.index";
		//System.out.println("hello");
		if(!accountService.isValid(accounts.getUserNames(),accounts.getPasswords())){
			modelMap.addAttribute("error","wrong username or password");
		
			return "user.login.index";
		}
		 session = request.getSession(); 
		session.setAttribute("account", accounts);
		
		redirectAttrs.addFlashAttribute("account1", accounts);
		return "redirect:/user/product.html";
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session,ModelMap modelMap,@ModelAttribute("accounts")Accounts accounts){
		session.removeAttribute("cart");
		session.removeAttribute("account");
		return "user.login.index";
	}
	
	@RequestMapping(value="/403",method = RequestMethod.GET)
	public String accessDenied(ModelMap modelMap) {
		Authentication authentication= SecurityContextHolder.getContext()
				.getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)){
			UserDetails userDetails=(UserDetails) authentication.getPrincipal();
			modelMap.addAttribute("username",userDetails.getUsername());
		}
		return "user.login.index";
	}
	
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcome(ModelMap modelMap) {
		return "welcome";
	}

}
