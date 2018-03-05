package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Orders> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
		
	}

	@Override
	public void addOrder(Orders orders) {
		// TODO Auto-generated method stub
		orderDAO.addOrder(orders);
	}

	@Override
	public void editOrder(Orders orders, int id) {
		orderDAO.updateOrder(orders, id);
		
	}

	@Override
	public Orders findById(int id) {
		// TODO Auto-generated method stub
		return orderDAO.findOrder(id);
	}

}
