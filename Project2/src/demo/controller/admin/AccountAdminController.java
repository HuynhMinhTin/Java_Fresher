package demo.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import demo.entities.*;
import demo.model.*;
import demo.services.*;

import demo.validator.*;

@Controller
@RequestMapping("admin/account**")
public class AccountAdminController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RoleService roleService;
	 
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		//AccountModel accountModel=new AccountModel();
		modelMap.put("accounts", accountService.findAll());
		
		return "admin.account.index";
	}
	
	@RequestMapping(value = "/delete/{accountId}", method = RequestMethod.GET)
	public String delete(@PathVariable("accountId") Integer accountId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		accountService.deleteAccount(accountId);
		modelMap.put("accounts", accountService.findAll());
	    return "redirect:/admin/account.html";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("accounts") @Valid Accounts accounts,
			BindingResult bindingResult,ModelMap modelMap) {
		
		
		//modelMap.put("categories", new );
		modelMap.put("role1", roleService.findAll());
		return "admin.account.register";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,@ModelAttribute("accounts") @Valid Accounts accounts,
			BindingResult bindingResult ) throws ParseException {
		
		accounts.setStatus(true);
		AccountValidator accountValidator=new AccountValidator();
		accountValidator.validate(accountValidator, bindingResult);
		
		if (bindingResult.hasErrors()){
			
			return "redirect:/admin/account/register.html";
			
			
		}
		else{
			accountService.addAccount(accounts);
			return "redirect:/admin/account.html";
		}
	}
	
	@RequestMapping(value = "/detail/{accountId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("accounts") @Valid Accounts accounts,BindingResult bindingResult, ModelMap modelMap,
			@PathVariable("accountId") Integer accountId) {
		modelMap.put("accounts", accountService.findById(accountId));
		modelMap.put("accountId", accountId);
	    return "admin.account.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{accountId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("accounts")@Valid Accounts accounts,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("accountId") Integer accountId) {
		AccountValidator accountValidator=new AccountValidator();
		accountValidator.validate(accountValidator, bindingResult);
		
		if (bindingResult.hasErrors()){
			//System.out.println("error");
			accountService.editAccount(accounts,accountId);
			return "redirect:/admin/account/detail/{accountId}.html";
			
		}
		else{
		
		accountService.editAccount(accounts,accountId);
	    return "redirect:/admin/account.html";
		}
	}
	
}
