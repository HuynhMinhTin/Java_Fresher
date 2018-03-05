package demo.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import demo.entities.Orders;
public class OrderValidator implements Validator {

 private Pattern pattern;
 private Matcher matcher;

 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 String ID_PATTERN = "[0-9]+";
 String STRING_PATTERN = "[a-zA-Z]+";
 String MOBILE_PATTERN = "[0-9]{10}";
 String SIZE_PATTERN = ".{5,30}";
 @Override
 public boolean supports(Class arg0) {
  // TODO Auto-generated method stub
  return Orders.class.equals(arg0);
 }

 @Override
 public void validate(Object target, Errors errors) {

  Orders orders = (Orders) target;
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress",
			"required.customerAddress", "Customer Address is required.");
  if (!(orders.getCustomerEmail() != null && orders.getCustomerAddress().isEmpty())) {
		pattern = Pattern.compile(SIZE_PATTERN);
		matcher = pattern.matcher(orders.getCustomerAddress());
		if (!matcher.matches()) {
			errors.rejectValue("customerAddress", "customerAddress.incorrect",
			"Customer Address character number  must be betweent 5 and 30");
		}
  } 

 
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName",
			"required.customerName", "Customer Name is required.");
  if (!(orders.getCustomerName() != null && orders.getCustomerName().isEmpty())) {
		pattern = Pattern.compile(SIZE_PATTERN);
		matcher = pattern.matcher(orders.getCustomerName());
		if (!matcher.matches()) {
			errors.rejectValue("customerName", "customerName.incorrect",
			"Customer Address character number  must be betweent 5 and 30");
		}
} 
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerEmail",
			"required.customerEmail", "Email is required.");
  if (!(orders.getCustomerEmail() != null && orders.getCustomerEmail().isEmpty())) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(orders.getCustomerEmail());
		if (!matcher.matches()) {
			errors.rejectValue("customerEmail", "customerEmail.incorrect",
			"Enter a correct email");
		}
  }
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerPhone",
	"required.customerPhone", "Phone is required.");
	if (!(orders.getCustomerPhone() != null && orders.getCustomerPhone().isEmpty())) {
		pattern = Pattern.compile(MOBILE_PATTERN);
		matcher = pattern.matcher(orders.getCustomerPhone());
		if (!matcher.matches()) {
				errors.rejectValue("customerPhone", "customerPhone.incorrect",
				"Enter a correct phone number");
		}
	}
	

 }
}