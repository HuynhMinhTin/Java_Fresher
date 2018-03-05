package demo.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entities.Accounts;
import demo.entities.Categories;
public class CategoryValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Categories.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
