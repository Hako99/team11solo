package com.example.team11solo.domain.booking.entity;

import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import com.example.team11solo.global.util.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE Booking SET deleted_at = NOW() WHERE booking_id = ?")
@SQLRestriction(value = "deleted_at is NULL")
public class Booking extends Timestamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id", nullable = false)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "shop_id", nullable = false)
  private Long shopId;

  @Column(name = "ticket_number", nullable = false)
  private Long ticketNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "booking_state",nullable = false)
  private BookingType state;

  @Column(name = "booking_party",nullable = false)
  private Integer party;

  public Booking(BookingCreateRequestDto bookingCreateRequestDto,Long maxTicketNumber) {
    this.userId = bookingCreateRequestDto.getUserId();
    this.shopId = bookingCreateRequestDto.getShopId();
    this.party = bookingCreateRequestDto.getParty();
    this.state = BookingType.WAITING;
    this.ticketNumber = maxTicketNumber+1L;
  }

  public void collingCustomer() {
    this.state = BookingType.COLLING;
  }
  public void noShow(){
    this.state = BookingType.NOSHOW;
  }
  public void done(){
    this.state = BookingType.DONE;
  }

  public void wellDone() {
    this.state = BookingType.WELLDONE;
  }
  public void cancle(){
    this.state = BookingType.CANCEL;
  }
}
