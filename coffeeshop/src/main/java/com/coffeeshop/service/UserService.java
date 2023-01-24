package com.coffeeshop.service;

import java.util.List;

import com.coffeeshop.dto.UserDTO;

public interface UserService{
	UserDTO saveUpdateUser(UserDTO userDTO);
	List<UserDTO> getUsers();
	void removeUserDetailsById(Long id);
	UserDTO getUserDetailsById(Long id);
	
}
