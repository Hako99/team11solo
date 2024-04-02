package com.example.team11solo.domain.booking.entity;

import lombok.Getter;

@Getter
public enum BookingType {

  WAITING, // 대기중
  COLLING, // 호출
  DONE,    // 입장
  WELLDONE, // 식사 종료
  CANCEL,  // 취소
  NOSHOW   // 노쇼

}
