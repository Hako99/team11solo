package com.example.team11solo.domain.booking.service;

import com.example.team11solo.domain.alarm.service.AlarmService;
import com.example.team11solo.domain.booking.dto.request.BookingCreateRequestDto;
import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.entity.BookingType;
import com.example.team11solo.domain.booking.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import java.awt.print.Book;
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

  @Override
  public void bookingCancle(Long bookingId) {
    Booking booking = bookingRepository.findById(bookingId)
        .orElseThrow(() -> new EntityNotFoundException("줄서기 내용이 존재하지 않습니다."));
    if(booking.getState() == BookingType.DONE || booking.getState() == BookingType.WELLDONE ){
      throw new RuntimeException("이미 입장 완료된 줄서기는 취소할 수 없습니다.");
    }
    if(booking.getState() == BookingType.CANCEL){
      throw new RuntimeException("이미 취소된 줄서기 내역 입니다.");
    }
    if(booking.getState() == BookingType.NOSHOW){
      throw new RuntimeException("해당 줄서기 내역은 취소하실 수 없습니다.");
    }
    booking.cancle();
    alarmService.sendMessage
        (booking.getUserId(), booking.getUserId() + "번 손님 줄서기를 취소하셨습니다.");
    alarmService.alarmClose(booking.getUserId());
  }

}
