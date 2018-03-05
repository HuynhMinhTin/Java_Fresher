package demo.controller.admin;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.CategoryService;
import demo.services.ProductService;
import demo.services.RoleService;
@Controller
@RequestMapping("admin/role")
public class RoleAdminController {
	@Autowired
	private RoleService roleService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		RoleModel roleModel=new RoleModel();
		modelMap.put("roles", roleService.findAll());
		return "admin.role.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("roles") Roles roles,ModelMap modelMap) {
		
		
		//modelMap.put("categories", new );
		return "admin.role.register";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,@ModelAttribute("roles") @Valid Roles roles,BindingResult bindingResult) throws ParseException {
		//categoryService;
		if (bindingResult.hasErrors()){
			return "admin.role.register";		
		}
		roleService.addRole(roles);
	    return "redirect:/admin/role.html";
	}
	
	@RequestMapping(value = "/delete/{roleId}", method = RequestMethod.GET)
	public String delete(@PathVariable("roleId") Integer roleId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		roleService.deleteRole(roleId);
		modelMap.put("roles", roleService.findAll());
	    return "redirect:/admin/role.html";
	}
	
	@RequestMapping(value = "/detail/{roleId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("roles") Roles roles, ModelMap modelMap,
			@PathVariable("roleId") Integer roleId) {
		modelMap.put("roles", roleService.findById(roleId));
		//roles.setId(78);
		//roles.setName("gfgfgf");
		//modelMap.put("roleId", roleId);
	    return "admin.role.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{roleId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("roles") @Valid Roles roles,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("roleId") Integer roleId) throws ParseException {
		if (bindingResult.hasErrors()){
			return "admin.role.detail";		
		}
		roleService.editRole(roles,roleId);
		modelMap.put("roles", roleService.findAll());
	    return "redirect:/admin/role.html";
	}
	
}
