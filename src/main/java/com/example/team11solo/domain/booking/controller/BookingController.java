package com.example.team11solo.domain.booking.controller;

import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import com.example.team11solo.domain.booking.service.BookingService;
import com.example.team11solo.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

  private final BookingService bookingService;

  // 줄서기 시작
  @PostMapping
  public ResponseEntity<ResponseDto<Void>> createBooking(@RequestBody BookingCreateRequestDto bookingCreateRequestDto) {
    bookingService.createBooking(bookingCreateRequestDto);
    return ResponseEntity.ok().body(ResponseDto.<Void>builder()
        .statusCode(HttpStatus.OK.value())
        .data(null)
        .build());
  }

}
