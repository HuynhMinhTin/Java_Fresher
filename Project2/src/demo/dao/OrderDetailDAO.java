package demo.dao;

import java.util.*;

import demo.entities.*;

public interface OrderDetailDAO {

	public List<OrderDetails> findAll();
	public void deleteOrderDetails(OrderDetailsId id);
	public void updateOrderDetails(OrderDetails orderDetails, OrderDetailsId id);
	public void addOrderDetails(OrderDetails orderDetails);
	public OrderDetails findOrderDetails(int id);
	
}
