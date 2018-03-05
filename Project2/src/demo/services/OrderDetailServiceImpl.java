package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("orderdetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public List<OrderDetails> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public void deleteOrderDetail(int productId, int orderId) {
		// TODO Auto-generated method stub
		OrderDetailsId orderDetailsId=new OrderDetailsId(orderId, productId);
		orderDetailDAO.deleteOrderDetails(orderDetailsId);
		
	}

	

	@Override
	public void editOrderDetail(OrderDetails orderDetails,int productId, int orderId) {
		OrderDetailsId orderDetailsId=new OrderDetailsId(orderId, productId);
		orderDetailDAO.updateOrderDetails(orderDetails, orderDetailsId);
		
	}

	

	@Override
	public void addOrderDetail(OrderDetails orderDetails) {
		
		orderDetailDAO.addOrderDetails(orderDetails);
	}

	
	

	

	
}
