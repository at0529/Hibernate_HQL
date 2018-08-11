package com.abc.Dao;

import com.abc.pojo.OrderItem;
import com.abc.pojo.OrderItemId;

public interface OrderItemDao {

	OrderItem getOrderItem(OrderItemId id);
	
	OrderItem updateOrderItem(OrderItem ord);
	
	OrderItem createOrderItem(OrderItem ord);
	
	boolean deleteOrderItem(OrderItemId id);
	
}
