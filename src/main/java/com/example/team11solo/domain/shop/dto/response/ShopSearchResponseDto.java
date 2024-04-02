package com.example.team11solo.domain.shop.dto.response;

import com.example.team11solo.domain.shop.entity.Shop;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class ShopSearchResponseDto {

  private Long shopId;
  private String name;
  private String city;
  private Time openTime;
  private Time closeTime;

  public ShopSearchResponseDto(Shop shop){
    this.shopId = shop.getId();
    this.name = shop.getName();
    this.city = shop.getCity();
    this.openTime = shop.getOpenTime();
    this.closeTime = shop.getCloseTime();

  }

}
