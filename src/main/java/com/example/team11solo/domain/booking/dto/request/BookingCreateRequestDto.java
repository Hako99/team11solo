package com.example.team11solo.domain.booking.dto.request;

import lombok.Getter;

@Getter
public class BookingCreateRequestDto {

  private Long userId;
  private Long shopId;
  private Integer party;

}
