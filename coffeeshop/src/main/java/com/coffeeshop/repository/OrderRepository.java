package com.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
