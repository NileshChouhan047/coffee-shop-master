package com.coffeeshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.dto.OrderDTO;
import com.coffeeshop.entity.Order;
import com.coffeeshop.repository.OrderRepository;
import com.coffeeshop.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO saveUpdateOrder(OrderDTO orderDTO) {
        log.info("saveUpdateOrder method started Order name :: "+orderDTO.getName());
        Order order = modelMapper.map(orderDTO,Order.class);
          Order savedOrder = orderRepository.saveAndFlush(order);
          OrderDTO savedOrderDTO = modelMapper.map(savedOrder,OrderDTO.class);
        log.info("Order Saved Successfully orderId :: "+savedOrder.getId());
        return savedOrderDTO;
    }

    @Override
    public List<OrderDTO> getShops() {
        log.info("getUser method started.");
        List<Order> orders = (List<Order>) orderRepository.findAll();
        List<OrderDTO> orderDTOS = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
        log.info("getShop method completed total shops :: "+orders.size());
        return orderDTOS;
    }

    @Override
    public void removeOrderDetailsById(Long id) {
        log.info("removeOrder method started shop id ::"+id);
        getOrderDetailsById(id);
        orderRepository.deleteById(id);
        log.info("removeOrder method ended");
    }


}
