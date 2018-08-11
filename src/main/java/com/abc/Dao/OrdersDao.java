package com.abc.Dao;

import java.util.List;

import com.abc.pojo.Orders;

public interface OrdersDao {

	Orders getOrders(int id);
	
	Orders createOrders(Orders o);
	
	Orders updateOrders(Orders o);
	
	boolean deleteOrders(int id);
	
	List<Orders> getOrders1(Double totalOrderPrice);
	
	
}
