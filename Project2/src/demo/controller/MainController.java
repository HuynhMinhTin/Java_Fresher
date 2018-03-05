package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import demo.model.AccountModel;

@Controller
@RequestMapping(value="main")
public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "redirect:/main/login.html";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(ModelMap modelMap,
			@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout
			) {
		if(error!=null){
			modelMap.addAttribute("msg","You have either enter wrong username or password.");
		}
		if(logout!=null){
			modelMap.addAttribute("msg","You have signeded out");
		}
		
		return "login";
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(){
		return "login";
	}
	
	@RequestMapping(value="/403",method = RequestMethod.GET)
	public String accessDenied(ModelMap modelMap) {
		Authentication authentication= SecurityContextHolder.getContext()
				.getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)){
			UserDetails userDetails=(UserDetails) authentication.getPrincipal();
			modelMap.addAttribute("username",userDetails.getUsername());
		}
		return "403";
	}
	
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcome(ModelMap modelMap) {
		return "welcome";
	}
}
