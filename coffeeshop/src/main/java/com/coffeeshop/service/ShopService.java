package com.coffeeshop.service;

import java.util.List;

import com.coffeeshop.dto.ShopDTO;


public interface ShopService {
	ShopDTO saveUpdateShop(ShopDTO shopDTO);
	List<ShopDTO> getShops();
	void removeShopDetailsById(Long id);
	ShopDTO getUserDetailsById(Long id);

}
