package demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/superadmin**")
public class SuperAdminController {
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap modelMap){
		modelMap.addAttribute("msg","This is SuperAdmin Page");
		return "welcome";
	}
	

}
