package com.example.team11solo.domain.shop.controller;

import com.example.team11solo.domain.shop.dto.request.ShopCreateRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopSearchRequestDto;
import com.example.team11solo.domain.shop.dto.request.ShopUpdateRequestDto;
import com.example.team11solo.domain.shop.dto.response.ShopResponseDto;
import com.example.team11solo.domain.shop.dto.response.ShopSearchResponseDto;
import com.example.team11solo.domain.shop.service.ShopService;
import com.example.team11solo.global.dto.ResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public void createShop(@RequestBody ShopCreateRequestDto shopCreateRequestDto) {
    shopService.createShop(shopCreateRequestDto);
  }

  // 가게 수정
  @PutMapping
  public void updateShop(
      @RequestBody ShopUpdateRequestDto shopUpdateRequestDto) {
    shopService.updateShop(shopUpdateRequestDto);
  }

  // 가게 검색
  @GetMapping
  public ResponseEntity<ResponseDto<List<ShopSearchResponseDto>>> searchShop(
      @RequestBody ShopSearchRequestDto shopSearchRequestDto) {
    return ResponseEntity.ok().body(ResponseDto.<List<ShopSearchResponseDto>>builder()
        .statusCode(HttpStatus.OK.value())
        .data(shopService.searchShop(shopSearchRequestDto))
        .build());
  }

  // 가게 단일 검색
  @GetMapping("/{shopId}")
  public ResponseEntity<ResponseDto<ShopResponseDto>> viewShop(
      @PathVariable Long shopId
  ){   return ResponseEntity.ok().body(ResponseDto.<ShopResponseDto>builder()
      .statusCode(HttpStatus.OK.value())
      .data(shopService.viewShop(shopId))
      .build());
  }


}
