package com.example.team11solo.domain.customer.service;

import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.repository.BookingRepository;
import com.example.team11solo.domain.customer.dto.response.BookingCustomersResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

  private final BookingRepository bookingRepository;
  @Override
  public List<BookingCustomersResponseDto> checkBookingCustomers(Long shopId) {
    List<Booking> bookingList = bookingRepository.findBookingCustomers(shopId);
    return bookingList.stream().map(BookingCustomersResponseDto::new).toList();
  }
}
