package com.example.team11solo.domain.shop.entity;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.global.util.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Time;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends Timestamp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shop_id", nullable = false)
  private Long id;
  @Column(name = "shop_name", nullable = false)
  private String name;
  @Column(name = "shop_address", nullable = false)
  private String address;
  @Column(name = "shop_city", nullable = false)
  private String city;
  @Column(name = "shop_phone", nullable = false)
  private String phone;
  @Column(name = "shop_introduce", nullable = true)
  private String introduce;
  @Column(name = "shop_opentime", nullable = false)
  private Time openTime;
  @Column(name = "shop_closetime", nullable = false)
  private Time closeTime;




  public Shop(ShopCreateRequestDto shopCreateRequestDto) {
    this.name = shopCreateRequestDto.getName();
    this.address = shopCreateRequestDto.getAddress();
    this.city = shopCreateRequestDto.getCity();
    this.phone =
        shopCreateRequestDto.getPhoneFirst() + "-" + shopCreateRequestDto.getPhoneSecond() + "-"
            + shopCreateRequestDto.getPhoneThird();
    this.introduce = shopCreateRequestDto.getIntroduce();
    this.openTime = Time.valueOf(shopCreateRequestDto.getOpenTimeHour()+":"+shopCreateRequestDto.getOpenTimeMinute()+":00");
    this.closeTime = Time.valueOf(shopCreateRequestDto.getCloseTimeHour()+":"+shopCreateRequestDto.getCloseTimeMinute()+":00");
  }


}
