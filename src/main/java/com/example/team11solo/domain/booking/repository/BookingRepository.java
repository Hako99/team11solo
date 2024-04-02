package com.example.team11solo.domain.booking.repository;

import com.example.team11solo.domain.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> , BookingRepositoryCustom{

}
