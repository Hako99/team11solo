package com.example.team11solo.domain.booking.service;

import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;

public interface BookingService {

  void createBooking(BookingCreateRequestDto bookingCreateRequestDto);

}
