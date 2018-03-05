package demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="multiplelanguage")
public class MutipleLanguageController {
	
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method = RequestMethod.GET)
		public String index (ModelMap modelMap){
			return "multiplelanguage";
		}
	
}
