package com.coffeeshop.service;

import java.util.List;

import com.coffeeshop.dto.OrderDTO;



public interface OrderService {

	OrderDTO saveUpdateOrder(OrderDTO orderDTO);
	List<OrderDTO> getOrders();
	void removeOrderDetailsById(Long id);
	OrderDTO getOrderDetailsById(Long id);
}
