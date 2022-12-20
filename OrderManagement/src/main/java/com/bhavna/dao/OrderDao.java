package com.bhavna.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.bean.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {
	Orders findByOrderCategory(String categoryName);
}
