package com.example.team11solo.domain.booking.service;

import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface BookingService {

  SseEmitter createBooking(BookingCreateRequestDto bookingCreateRequestDto);

}
