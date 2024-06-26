package com.example.team11solo.domain.shop.entity;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopUpdateRequestDto;
import com.example.team11solo.global.util.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE Shop SET deleted_at = NOW() WHERE shop_id = ?")
@SQLRestriction(value = "deleted_at is NULL")
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
  @Column(name = "shop_keyword", nullable = true)
  private String keyword;




  public Shop(ShopCreateRequestDto shopCreateRequestDto) {
    this.name = shopCreateRequestDto.getName();
    this.address = shopCreateRequestDto.getAddress();
    this.city = shopCreateRequestDto.getCity();
    this.phone =
        shopCreateRequestDto.getPhoneFirst() + "-" + shopCreateRequestDto.getPhoneSecond() + "-"
            + shopCreateRequestDto.getPhoneThird();
    this.introduce = shopCreateRequestDto.getIntroduce();
    this.openTime = Time.valueOf(
        shopCreateRequestDto.getOpenTimeHour() + ":" + shopCreateRequestDto.getOpenTimeMinute()
            + ":00");
    this.closeTime = Time.valueOf(
        shopCreateRequestDto.getCloseTimeHour() + ":" + shopCreateRequestDto.getCloseTimeMinute()
            + ":00");
    this.keyword = shopCreateRequestDto.getKeyword();
  }


  public void updateShop(ShopUpdateRequestDto shopUpdateRequestDto) {
    if (shopUpdateRequestDto.getName() != null) {
      this.name = shopUpdateRequestDto.getName();
    }
    if (shopUpdateRequestDto.getAddress() != null) {
      this.address = shopUpdateRequestDto.getAddress();
    }
    if (shopUpdateRequestDto.getCity() != null) {
      this.city = shopUpdateRequestDto.getCity();
    }
    if (shopUpdateRequestDto.getPhoneFirst() != null
        && shopUpdateRequestDto.getPhoneSecond() != null
        && shopUpdateRequestDto.getPhoneThird() != null) {
      this.phone =
          shopUpdateRequestDto.getPhoneFirst() + "-" + shopUpdateRequestDto.getPhoneSecond() + "-"
              + shopUpdateRequestDto.getPhoneThird();
    }
    if (shopUpdateRequestDto.getIntroduce() != null) {
      this.introduce = shopUpdateRequestDto.getIntroduce();
    }
    if (shopUpdateRequestDto.getOpenTimeHour() != null
        && shopUpdateRequestDto.getOpenTimeMinute() != null) {
      this.openTime = Time.valueOf(
          shopUpdateRequestDto.getOpenTimeHour() + ":" + shopUpdateRequestDto.getOpenTimeMinute()
              + ":00");
    }
    if (shopUpdateRequestDto.getCloseTimeHour() != null
        && shopUpdateRequestDto.getCloseTimeMinute() != null) {
      this.closeTime = Time.valueOf(
          shopUpdateRequestDto.getCloseTimeHour() + ":" + shopUpdateRequestDto.getCloseTimeMinute()
              + ":00");
    }
    if (shopUpdateRequestDto.getKeyword() != null){
      this.keyword = shopUpdateRequestDto.getKeyword();
    }
  }
}
