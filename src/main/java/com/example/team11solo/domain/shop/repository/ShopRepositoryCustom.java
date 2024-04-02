package com.example.team11solo.domain.shop.repository;

import com.example.team11solo.domain.shop.entity.Shop;
import java.util.List;

public interface ShopRepositoryCustom {

  List<Shop> searchShop(String search);

}
