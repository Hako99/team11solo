package com.example.team11solo.domain.customer.dto.response;

import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.entity.BookingType;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BookingCustomersResponseDto {

  // 티켓번호
  // 유저 id
  // 현재 상태
  // 인원수
  // 예약 시간
  private Long ticketNumber;
  private Long userId;
  private BookingType state;
  private Integer party;
  private LocalDateTime createdAt;

  public BookingCustomersResponseDto(Booking booking){
    this.ticketNumber = booking.getTicketNumber();
    this.userId = booking.getUserId();
    this.state = booking.getState();
    this.party = booking.getParty();
    this.createdAt = booking.getCreatedAt();

  }



}
