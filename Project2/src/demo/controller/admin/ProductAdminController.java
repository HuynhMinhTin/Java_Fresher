package demo.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;

import demo.model.ProductModel;
import demo.services.AccountService;
import demo.services.CategoryService;
import demo.services.ProductService;

@Controller
@RequestMapping("admin/product")
public class ProductAdminController implements ServletContextAware {
	private ServletContext servletContext;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		modelMap.put("products", productService.findAll());
		
		return "admin.product.index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap modelMap,@ModelAttribute("products") Products products) {
		
		
		//modelMap.put("categories", new );
		modelMap.put("category", categoryService.findAll());
		return "admin.product.register";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ModelMap modelMap,@RequestParam(value = "image", required = false) MultipartFile image,
			@ModelAttribute("products") @Valid Products products,BindingResult bindingResult) 
	
					throws ParseException {
		//categoryService;
		

		//Categories categories=new Categories();
		//categories.setId(2);
		
		String datepicker="";
		//products.setCategories(categories);
		//SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		//products.setCreateDate(dt.parse(datepicker));
		System.out.println(products.getCreateDate());
		products.setCreateDate(dt.parse("1998-01-01 23:59:59.993"));
		products.setImages(saveImage(image));
		
		if (bindingResult.hasErrors()){
			
			modelMap.put("category", categoryService.findAll());
			return "admin.product.register";		
		}
		else{
			productService.addProduct(products);
		    return "redirect:/admin/product.html";
		}
	
	}
	
	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
	public String delete(@PathVariable("productId") Integer productId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		productService.deleteProduct(productId);
		modelMap.put("products", productService.findAll());
	    return "redirect:/admin/product.html";
	}
	@RequestMapping(value = "/productdetail/{productId}", method = RequestMethod.GET)
	public String productdetail(@ModelAttribute("products") @Valid Products products,BindingResult bindingResult
			, ModelMap modelMap,
			@PathVariable("productId") Integer productId) {
		modelMap.put("products", productService.findById(productId));
		modelMap.put("category", categoryService.findAll());
		modelMap.put("producttId", productId);
	    return "admin.product.productdetail";
	}
	@RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("products") @Valid Products products,BindingResult bindingResult
			, ModelMap modelMap,
			@PathVariable("productId") Integer productId) {
		modelMap.put("products", productService.findById(productId));
		modelMap.put("category", categoryService.findAll());
		modelMap.put("producttId", productId);
	    return "admin.product.detail";
	}
	
	@RequestMapping(value = "/detail/edit/{productId}", method = RequestMethod.POST)
	public String edit(@RequestParam(value = "image", required = false) MultipartFile image,
			@ModelAttribute("products") @Valid Products products,BindingResult bindingResult,
			ModelMap modelMap,
			@PathVariable("productId") Integer productId) throws ParseException {
			
		
		if (bindingResult.hasErrors()){
			System.out.println("error");
			modelMap.put("category", categoryService.findAll());
			return "admin.product.detail";		
		}
		else{
			products.setImages(saveImage(image));
			productService.editProduct(products,productId);
		    return "redirect:/admin/product.html";
		}
	}
	private String saveImage(MultipartFile image) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/user/images/" + image.getOriginalFilename());
			System.out.println(file.getAbsolutePath());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return image.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}
	private boolean validateImage(MultipartFile image) {
		return image.getContentType().equals("image/jpeg") || image.getContentType().equals("image/jpg")
				|| image.getContentType().equals("image/gif") || image.getContentType().equals("image/png");
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
		
}
