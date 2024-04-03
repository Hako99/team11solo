package com.example.team11solo.domain.booking.service;

import com.example.team11solo.domain.alarm.service.AlarmService;
import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.repository.BookingRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

  private final BookingRepository bookingRepository;
  private final AlarmService alarmService;

  @Override
  public SseEmitter createBooking(BookingCreateRequestDto bookingCreateRequestDto) {
    LocalDate now = LocalDate.now();
    Long maxTicketNumber = bookingRepository.findMaxTicket(bookingCreateRequestDto.getShopId(),
        now);
    if (maxTicketNumber == null) {
      maxTicketNumber = 0L;
    }
    Booking booking = new Booking(bookingCreateRequestDto, maxTicketNumber);
    bookingRepository.save(booking);
    return alarmService.subscribe(bookingCreateRequestDto.getUserId());
  }
}
