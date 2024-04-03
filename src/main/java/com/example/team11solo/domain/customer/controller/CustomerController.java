package com.example.team11solo.domain.customer.controller;

import com.example.team11solo.domain.customer.dto.request.CollingCustomerRequestDto;
import com.example.team11solo.domain.customer.dto.response.BookingCustomersResponseDto;
import com.example.team11solo.domain.customer.service.CustomerService;
import com.example.team11solo.global.dto.ResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  // 현재 내 상점에 줄서있는 손님 체크하기
  @GetMapping("/{shopId}")
  public ResponseEntity<ResponseDto<List<BookingCustomersResponseDto>>> checkBookingCustomers(
      @PathVariable Long shopId
  ) {
    return ResponseEntity.ok().body(ResponseDto.<List<BookingCustomersResponseDto>>builder()
        .statusCode(HttpStatus.OK.value())
        .data(customerService.checkBookingCustomers(shopId))
        .build());
  }

  // 대기중인 손님 호출하기
  @PostMapping
  public ResponseEntity<ResponseDto<Void>> collingCustomer(
      @RequestBody CollingCustomerRequestDto collingCustomerRequestDto) {
    customerService.collingCustomer(collingCustomerRequestDto);

    return ResponseEntity.ok().body(ResponseDto.<Void>builder()
        .statusCode(HttpStatus.OK.value())
        .data(null)
        .build());
  }

  // 손님 입장
  @PostMapping("/{userId}")
  public ResponseEntity<ResponseDto<Void>> doneCustomer(
      @PathVariable Long userId
  ){
    customerService.doneCustomer(userId);
    return ResponseEntity.ok().body(ResponseDto.<Void>builder()
        .statusCode(HttpStatus.OK.value())
        .data(null)
        .build());
  }

  // 손님 퇴장
  @DeleteMapping("/{userId}")
  public ResponseEntity<ResponseDto<Void>> wellDoneCustomer(
      @PathVariable Long userId
  ){
    customerService.wellDoneCustomer(userId);
    return ResponseEntity.ok().body(ResponseDto.<Void>builder()
        .statusCode(HttpStatus.OK.value())
        .data(null)
        .build());
  }

}
