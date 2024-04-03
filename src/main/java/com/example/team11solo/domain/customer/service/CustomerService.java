package com.example.team11solo.domain.customer.service;

import com.example.team11solo.domain.customer.dto.request.CollingCustomerRequestDto;
import com.example.team11solo.domain.customer.dto.response.BookingCustomersResponseDto;
import com.example.team11solo.global.dto.event.NoShowEventRequestDto;
import java.util.List;
import org.springframework.context.event.EventListener;

public interface CustomerService {

  List<BookingCustomersResponseDto> checkBookingCustomers(Long shopId);

  void collingCustomer(CollingCustomerRequestDto collingCustomerRequestDto);
  @EventListener
  void noShowCustomer(NoShowEventRequestDto noShowEventRequestDto);

  void doneCustomer (Long userId);
}
