package com.coffeeshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import com.coffeeshop.dto.ShopDTO;
import com.coffeeshop.entity.Shop;
import com.coffeeshop.repository.ShopRepository;
import com.coffeeshop.service.ShopService;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService{
	@Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public ShopDTO saveUpdateShop(ShopDTO shopDTO) {
        log.info("saveUpdateShop method started Shop name :: "+shopDTO.getName());
        Shop shop = modelMapper.map(shopDTO,Shop.class);
          Shop savedShop = shopRepository.saveAndFlush(shop);
          ShopDTO savedShopDTO = modelMapper.map(savedShop,ShopDTO.class);
        log.info("Shop Saved Successfully shopId :: "+savedShop.getId());
        return savedShopDTO;
    }

    @Override
    public List<ShopDTO> getShops() {
        log.info("getUser method started.");
        List<Shop> shops = (List<Shop>) shopRepository.findAll();
        List<ShopDTO> shopDTOS = shops.stream().map(shop -> modelMapper.map(shop, ShopDTO.class)).collect(Collectors.toList());
        log.info("getShop method completed total shops :: "+shops.size());
        return shopDTOS;
    }

    @Override
    public void removeShopDetailsById(Long id) {
        log.info("removeShop method started shop id ::"+id);
        getShopDetailsById(id);
        shopRepository.deleteById(id);
        log.info("removeShop method ended");
    }

}
