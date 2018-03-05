package demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import demo.report.*;
@Controller
@RequestMapping("admin/productreport")
public class ProductReportController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductReport productReport=new ProductReport();
		modelMap.put("listProducts", productReport.searchAll());
		return "report";
	}
}
