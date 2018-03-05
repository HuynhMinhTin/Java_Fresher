package demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import demo.entities.ExcelFile;
import demo.entities.Products;
import demo.helper.ExcelHelper;
import demo.helper.UploadFileHelper;
import demo.services.*;



@Controller
@RequestMapping(value="excel")
public class ExcelController implements ServletContextAware {
	private ServletContext servletContext;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index (ModelMap modelMap){
		return "redirect:excel/import.html";
	}
	@RequestMapping(value="/import",method = RequestMethod.GET)
	public String importexcel (ModelMap modelMap){
		modelMap.put("excelFile", new ExcelFile());
	
		return "importexcel";
	}
	
	@RequestMapping(value="/importexcel",method = RequestMethod.POST)
	public String importexcel (@ModelAttribute (value="excelFile") ExcelFile excelFile,ModelMap modelMap,
			HttpServletRequest request) throws Exception{
	
		try {
	
		
			File file = new File(servletContext.getRealPath("/") + "/assets/excel/" + excelFile.getFile().getOriginalFilename());
			
			FileUtils.writeByteArrayToFile(file,excelFile.getFile().getBytes());
			System.out.println(servletContext.getRealPath("/") + "/assets/excel/" + excelFile.getFile().getOriginalFilename());
			ExcelHelper excelHelper=new ExcelHelper(file.getAbsolutePath());
			List<Products> products=excelHelper.readData(Products.class.getName());
			modelMap.put("listProducts", excelHelper.readData(Products.class.getName()));
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		modelMap.put("excelFile", new ExcelFile());
		return "excelsuccess";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
		
	}

}
