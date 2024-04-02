package com.example.team11solo.domain.customer.service;

import com.example.team11solo.domain.customer.dto.request.CollingCustomerRequestDto;
import com.example.team11solo.domain.customer.dto.response.BookingCustomersResponseDto;
import java.util.List;

public interface CustomerService {

  List<BookingCustomersResponseDto> checkBookingCustomers(Long shopId);

  void collingCustomer(CollingCustomerRequestDto collingCustomerRequestDto);
}
