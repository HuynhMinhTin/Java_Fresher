package demo.model;

import java.math.BigDecimal;
import java.util.*;
import org.hibernate.*;

import demo.entities.*;

public class AccountModel extends AbstractModel<Accounts> {
	public AccountModel(){
		super(Accounts.class);
	}
	
}
