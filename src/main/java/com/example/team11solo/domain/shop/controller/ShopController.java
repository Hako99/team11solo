package com.example.team11solo.domain.shop.controller;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {
  private final ShopService shopService;

  // 가게 등록
  @PostMapping
  public void createReviews(@RequestBody ShopCreateRequestDto shopCreateRequestDto) {
    shopService.createShop(shopCreateRequestDto);
  }

}
