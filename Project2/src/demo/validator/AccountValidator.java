package demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entities.*;

public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Accounts.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
