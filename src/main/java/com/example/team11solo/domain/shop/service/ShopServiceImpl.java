package com.example.team11solo.domain.shop.service;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.entity.Shop;
import com.example.team11solo.domain.shop.repository.ShopRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
}
