package com.example.team11solo.domain.shop.service;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopSearchRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopUpdateRequestDto;
import com.example.team11solo.domain.shop.dto.response.ShopResponseDto;
import com.example.team11solo.domain.shop.dto.response.ShopSearchResponseDto;
import com.example.team11solo.domain.shop.entity.Shop;
import com.example.team11solo.domain.shop.repository.ShopRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ShopServiceImpl implements ShopService {

  private final ShopRepository shopRepository;


  @Override
  public void createShop(ShopCreateRequestDto shopCreateRequestDto) {
    Shop shop = new Shop(shopCreateRequestDto);
    shopRepository.save(shop);

  }

  @Override
  public void updateShop(ShopUpdateRequestDto shopUpdateRequestDto) {
    Shop shop = findShop(shopUpdateRequestDto.getShopId());
    shop.updateShop(shopUpdateRequestDto);
  }

  @Override
  public List<ShopSearchResponseDto> searchShop(ShopSearchRequestDto shopSearchRequestDto) {
    List<Shop> shopList = shopRepository.searchShop(shopSearchRequestDto.getSearch());
    return shopList.stream().map(ShopSearchResponseDto::new).toList();

  }

  @Override
  public ShopResponseDto viewShop(Long shopId) {
    Shop shop = findShop(shopId);
    return new ShopResponseDto(shop);
  }

  @Override
  public void deleteShop(Long shopId) {
    Shop shop = findShop(shopId);
    shopRepository.delete(shop);
  }

  public Shop findShop(Long shopId) {
    return shopRepository.findById(shopId)
        .orElseThrow(() -> new EntityNotFoundException("등록되어있지 않은 가게 입니다."));
  }



}
