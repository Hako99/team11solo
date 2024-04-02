package com.example.team11solo.domain.shop.service;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopUpdateRequestDto;

public interface ShopService {

  void createShop(ShopCreateRequestDto shopCreateRequestDto);

  void updateShop(ShopUpdateRequestDto shopUpdateRequestDto);
}
