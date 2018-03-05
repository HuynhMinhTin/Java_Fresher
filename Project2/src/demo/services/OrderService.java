package demo.services;

import java.util.*;

import demo.entities.*;

public interface OrderService {

	public List<Orders> findAll();
	public void deleteOrder(int id);
	public void addOrder(Orders orders);
	public void editOrder(Orders orders,int id);
	public Orders findById (int id);
}
