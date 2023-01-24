package com.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
