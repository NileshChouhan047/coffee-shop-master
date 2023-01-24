package com.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop,Long> {

}
