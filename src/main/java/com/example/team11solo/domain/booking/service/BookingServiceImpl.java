package com.example.team11solo.domain.booking.service;

import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.repository.BookingRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

private final BookingRepository bookingRepository;

  @Override
  public void createBooking(BookingCreateRequestDto bookingCreateRequestDto) {
    LocalDate now = LocalDate.now();
    Long maxTicketNumber = bookingRepository.findMaxTicket(bookingCreateRequestDto.getShopId(),now);
    if(maxTicketNumber ==null){
      maxTicketNumber = 0L;
    }
    Booking booking = new Booking(bookingCreateRequestDto,maxTicketNumber);
    bookingRepository.save(booking);
  }
}
