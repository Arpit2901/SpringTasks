package com.bhavna.bean;


import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Orders {
	@Id
	private int orderId;
	private String orderCategory;
	private Date orderDate;
	private int quantity;
	
	public Orders() {
		super();
	}
	public Orders(int orderId, String orderCategory, Date orderDate, int quantity) {
		super();
		this.orderId = orderId;
		this.orderCategory = orderCategory;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCategory() {
		return orderCategory;
	}
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderCategory=" + orderCategory + ", orderDate=" + orderDate
				+ ", quantity=" + quantity + "]";
	}
	
	

}
