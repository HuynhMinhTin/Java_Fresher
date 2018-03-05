/*package demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import demo.entities2.*;
import demo.helper.UploadFileHelper;
import demo.model.AccountModel;
import demo.validator.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.SuffixFileFilter;


@Controller
@RequestMapping(value="upload")
public class UploadController {
	
	//@Autowired
	//private MultipartFile multipartFile;
	@RequestMapping(method = RequestMethod.GET)
	public String index (ModelMap modelMap){
		
		return "index";
	}
	
	@RequestMapping(value="simpleupload",method = RequestMethod.GET)
	public String simpleupload (ModelMap modelMap){
		modelMap.put("photo", new SimpleUploadFile());
		return "simpleupload";
	}
	
	@RequestMapping(value="simpleupload",method = RequestMethod.POST)
	public String index(ModelMap modelMap,
			@ModelAttribute(value="photo") @Valid SimpleUploadFile photo,
			BindingResult bindingResult, HttpServletRequest request
			) {
		SimpleUploadFileValidator simpleUploadFileValidator=new SimpleUploadFileValidator();
		simpleUploadFileValidator.validate(photo, bindingResult);
		if (bindingResult.hasErrors()){
			return "simpleupload";
		}
		else{
			modelMap.put("photo", UploadFileHelper.simpleUpload(photo.getFile(), request, true, "images"));
			return "upload_success";
		}
		
		
	}
	
}*/
