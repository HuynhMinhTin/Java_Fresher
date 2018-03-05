package demo.dao;

import java.util.*;

import demo.entities.*;

public interface OrderDAO {

	public List<Orders> findAll();
	public void deleteOrder(int id);
	public void updateOrder(Orders orders, int id);
	public void addOrder(Orders orders);
	public Orders findOrder(int id);
	
}
