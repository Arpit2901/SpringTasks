package com.bhavna.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.bean.Orders;
import com.bhavna.exception.ResourceNotFoundException;
import com.bhavna.service.OrderService;


@RestController
public class Controller {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/home")
	public String welcome() {
		return "Welcome to the home!";
	}
	
	@PostMapping("/placeOrder")
	public Object placeOrder(@RequestBody Orders order)  {
		return orderService.addOrder(order);
	}
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders()  {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/getByCategory/{orderCategory}")
	public List<Orders> getByCategory(@PathVariable String orderCategory){
		return orderService.getOrdersByCategory(orderCategory);
	}

	@PutMapping("/updateOrder/{categoryName}")
	public void updateOrder(@PathVariable String categoryName, @RequestBody Orders order) {
		orderService.updateByCategory(order, categoryName);
	}
	@PatchMapping("/PUpdateOrder/{categoryName}")
	public ResponseEntity<String> updateByPatch(@RequestBody Orders order, @PathVariable String categoryName) throws Exception {
		orderService.updateByPatch(order, categoryName);
	   // Orders.save(order, categoryName);
	    return ResponseEntity.ok("resource  updated");
	}
	
	@DeleteMapping("/deleteByOrderCategory/{category}")
	public void deleteByCategory(@PathVariable String category) throws ResourceNotFoundException {
		orderService.removeByCategory(category);

	}
}
