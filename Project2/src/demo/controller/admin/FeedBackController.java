package demo.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import demo.entities.*;
import demo.model.*;
import demo.services.*;
import demo.validator.OrderDetailValidator;
import demo.validator.OrderValidator;
@Controller
@RequestMapping("admin/feedback")
public class FeedBackController {
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
	
		modelMap.put("feedbacks", feedbackService.findAll());
		return "admin.feedback.index";
	}
	@RequestMapping(value = "/delete/{feedbackId}", method = RequestMethod.GET)
	public String delete(@PathVariable("feedbackId") Integer feedbackId, ModelMap modelMap) {
		//CategoryModel categoryModel=new CategoryModel();
		//categoryModel.Delete(categoryId);
		feedbackService.deleteFeedback(feedbackId);
		//modelMap.put("orders", orderDetailService.findAll());
	    return "redirect:/admin/feedback.html";
	}
	

}
