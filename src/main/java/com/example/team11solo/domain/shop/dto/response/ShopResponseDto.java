package com.example.team11solo.domain.shop.dto.response;

import com.example.team11solo.domain.shop.entity.Shop;
import java.sql.Time;
import lombok.Getter;

@Getter
public class ShopResponseDto {

  private String name;
  private String address;
  private String city;
  private String phone;
  private String introduce;
  private Time openTime;
  private Time closeTime;

  public ShopResponseDto(Shop shop) {
    this.name = shop.getName();
    this.address = shop.getAddress();
    this.city = shop.getCity();
    this.phone = shop.getPhone();
    this.introduce = shop.getIntroduce();
    this.openTime = shop.getOpenTime();
    this.closeTime = shop.getCloseTime();
  }
}
