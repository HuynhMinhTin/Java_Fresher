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

import demo.entities.Accounts;
import demo.entities.Roles;
import demo.model.*;
import demo.services.*;
import demo.services.CategoryService;
import demo.validator.AccountValidator;

@Controller
@RequestMapping("user/account")
@SessionAttributes("account1")
public class AccountUserController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap,HttpSession session) {
		//modelMap.put("accounts", new Accounts());
		return "user.account.index";
	}
	



	public Accounts checkCookie(ModelMap modelMap,HttpServletRequest request) {
		Cookie []cookies=request.getCookies();
		Accounts accounts=new Accounts();
		String username="",password="";
		return accounts;
	}
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(ModelMap modelMap,@ModelAttribute(value="accounts") Accounts accounts,
			HttpSession session,HttpServletRequest request) {
		accounts.setScore(10);
		return "user.account.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,@ModelAttribute("accounts") @Valid Accounts accounts,
			BindingResult bindingResult,@RequestParam("confirmPassword")String confirmPassword ) throws ParseException {
		
		
		AccountValidator accountValidator=new AccountValidator();
		accountValidator.validate(accountValidator, bindingResult);
		accounts.setStatus(true);
		accounts.setRoles(roleService.findById(4));
		accounts.setScore(10);
		if (accountService.isValid(accounts.getUserNames())){
			modelMap.addAttribute("error", "Username is already existed");
			return "user.account.register";
		}
		if(!accounts.getPasswords().equals(confirmPassword)){
			modelMap.addAttribute("error2", "Confirm Password and Password do not match");
			return "user.account.register";
		}
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult.toString());
			return "user.account.register";
			
			
		}
		else{
			accountService.addAccount(accounts);
			return "redirect:/user/product.html";
		}
	}


}
