package com.example.team11solo.domain.shop.repository;
import static com.example.team11solo.domain.shop.entity.QShop.shop;
import com.example.team11solo.domain.shop.entity.Shop;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ShopRepositoryCustomImpl implements ShopRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;
  @Override
  public List<Shop> searchShop(String search) {
    return jpaQueryFactory
        .select(shop)
        .from(shop)
        .where(shop.keyword.like("%"+search+"%"))
        .fetch();
  }
}
