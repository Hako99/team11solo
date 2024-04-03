package com.example.team11solo.domain.booking.repository;

import com.example.team11solo.domain.booking.entity.Booking;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepositoryCustom {
  Long findMaxTicket(Long shopId, LocalDate now);

  List<Booking> findBookingCustomers(Long shopId);

  List<Booking> findLateCustomers(LocalDateTime now);

  Booking findBookingByUserId(Long userId);
}
