package com.coffeeshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDTO {
	private Long id;
	private String name;
	private Long phonenumber;
	private String address;
}
