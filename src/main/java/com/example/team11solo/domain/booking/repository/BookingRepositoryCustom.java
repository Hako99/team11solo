package com.example.team11solo.domain.booking.repository;

import java.time.LocalDate;

public interface BookingRepositoryCustom {
  Long findMaxTicket(Long shopId, LocalDate now);
}
