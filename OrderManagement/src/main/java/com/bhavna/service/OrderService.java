package com.bhavna.service;

import java.util.List;

import com.bhavna.bean.Orders;

public interface OrderService {
	public Object addOrder(Orders order);
	
	public List<Orders> getAllOrders();
	
	public List<Orders> getOrdersByCategory(String ordercategory);
	
	public void removeByCategory(String category);
	
	public void updateByCategory(Orders order, String category);

	public void updateByPatch(Orders order, String categoryName) throws Exception;;
}
