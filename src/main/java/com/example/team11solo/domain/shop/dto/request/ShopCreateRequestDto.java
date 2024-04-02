package com.example.team11solo.domain.shop.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ShopCreateRequestDto {

  private String name;
  private String address;
  private String city;
  @Pattern(regexp = "^[0-9]*$")
  private String phoneFirst;
  @Pattern(regexp = "^[0-9]*$")
  private String phoneSecond;
  @Pattern(regexp = "^[0-9]*$")
  private String phoneThird;
  private String introduce;
  @Pattern(regexp = "^[0-9]*$")
  private String openTimeHour;
  @Pattern(regexp = "^[0-9]*$")
  private String openTimeMinute;
  @Pattern(regexp = "^[0-9]*$")
  private String closeTimeHour;
  @Pattern(regexp = "^[0-9]*$")
  private String closeTimeMinute;
  private String keyword;
}
