package com.example.team11solo.domain.shop.dto.request;

import lombok.Getter;

@Getter
public class ShopUpdateRequestDto {
  private Long shopId;
  private String name;
  private String address;
  private String city;
  private int phoneFirst;
  private int phoneSecond;
  private int phoneThird;
  private String introduce;
  private int openTimeHour;
  private int openTimeMinute;
  private int closeTimeHour;
  private int closeTimeMinute;
}
