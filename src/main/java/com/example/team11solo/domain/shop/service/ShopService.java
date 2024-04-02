package com.example.team11solo.domain.shop.service;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopSearchRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopUpdateRequestDto;
import com.example.team11solo.domain.shop.dto.response.ShopSearchResponseDto;
import com.example.team11solo.domain.shop.entity.Shop;
import java.util.List;

public interface ShopService {

  void createShop(ShopCreateRequestDto shopCreateRequestDto);

  void updateShop(ShopUpdateRequestDto shopUpdateRequestDto);

  List<ShopSearchResponseDto> searchShop(ShopSearchRequestDto shopSearchRequestDto);

}
