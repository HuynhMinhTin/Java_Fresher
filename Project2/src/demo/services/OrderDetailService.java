package demo.services;

import java.util.*;

import demo.entities.*;

public interface OrderDetailService {

	public List<OrderDetails> findAll();
	public void deleteOrderDetail(int productId, int orderId);
	public void addOrderDetail(OrderDetails orderDetails);
	public void editOrderDetail(OrderDetails orderDetails,int productId, int orderId);
	//public OrderDetails findById (int productId, int orderId);
}
