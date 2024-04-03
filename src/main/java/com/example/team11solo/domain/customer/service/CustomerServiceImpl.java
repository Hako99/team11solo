package com.example.team11solo.domain.customer.service;

import com.example.team11solo.domain.alarm.service.AlarmService;
import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.entity.BookingType;
import com.example.team11solo.domain.booking.repository.BookingRepository;
import com.example.team11solo.domain.customer.dto.request.CollingCustomerRequestDto;
import com.example.team11solo.domain.customer.dto.response.BookingCustomersResponseDto;
import com.example.team11solo.global.dto.event.NoShowEventRequestDto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

  private final BookingRepository bookingRepository;
  private final AlarmService alarmService;

  @Override
  public List<BookingCustomersResponseDto> checkBookingCustomers(Long shopId) {
    List<Booking> bookingList = bookingRepository.findBookingCustomers(shopId);
    return bookingList.stream().map(BookingCustomersResponseDto::new).toList();
  }

  @Override
  public void collingCustomer(CollingCustomerRequestDto collingCustomerRequestDto) {
    Booking booking = bookingRepository.findById(collingCustomerRequestDto.getBookingId())
        .orElseThrow(() -> new EntityNotFoundException("줄서기 내용이 존재하지 않습니다."));
    if (booking.getState() != BookingType.WAITING) {
      throw new RuntimeException("대기중인 줄서기가 아닙니다");
    }
    booking.collingCustomer();
    alarmService.sendMessage
        (booking.getUserId(), booking.getUserId() + "번 손님 입장하여 주시기 바랍니다");

  }


  @Override
  public void noShowCustomer(NoShowEventRequestDto noShowEventRequestDto) {
    List<Booking> lateBookings = bookingRepository.findLateCustomers(
        noShowEventRequestDto.getNow());
    for (Booking lateBooking : lateBookings) {
      lateBooking.noShow();
      alarmService.sendMessage
          (lateBooking.getUserId(),
              lateBooking.getUserId() + "번 손님 입장 시간이 초과하여 입장 취소되었습니다.");
      alarmService.alarmClose(lateBooking.getUserId());
    }
  }
}
