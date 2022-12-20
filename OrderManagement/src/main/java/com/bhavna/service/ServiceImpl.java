package com.bhavna.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.bean.Orders;
import com.bhavna.dao.OrderDao;

@Service
public class ServiceImpl implements OrderService {
	@Autowired
	OrderDao ordersRepository;

	@Override
	public Orders addOrder(Orders order) {
		return ordersRepository.save(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	@Override
	public List<Orders> getOrdersByCategory(String ordercategory) {
		return ordersRepository.findAll().stream().filter(s -> s.getOrderCategory().contentEquals(ordercategory))
				.collect(Collectors.toList());
		
	}

	@Override
	public void removeByCategory(String category) {
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(category)) {
				ordersRepository.deleteById(s.getOrderId());
		}});
	}

	@Override
	public void updateByCategory(Orders order, String category) {
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(category)) {
				ordersRepository.save(order);
				
		}});
	}

	@Override
	public void updateByPatch(Orders order, String categoryName) throws Exception {
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(categoryName)) {
				ordersRepository.save(order);
			}	
			});
		
	}

}
