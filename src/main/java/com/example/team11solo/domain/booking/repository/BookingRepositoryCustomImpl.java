package com.example.team11solo.domain.booking.repository;

import com.example.team11solo.domain.booking.entity.Booking;
import com.example.team11solo.domain.booking.entity.BookingType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.example.team11solo.domain.booking.entity.QBooking.booking;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookingRepositoryCustomImpl implements BookingRepositoryCustom{

  private final JPAQueryFactory jpaQueryFactory;
  @Override
  public Long findMaxTicket(Long shopId, LocalDate now) {
    return jpaQueryFactory
        .select(booking.ticketNumber)
        .from(booking)
        .where(booking.createdAt.goe(now.atStartOfDay()))
        .where(booking.shopId.eq(shopId))
        .orderBy(booking.ticketNumber.desc())
        .fetchFirst();
  }

  @Override
  public List<Booking> findBookingCustomers(Long shopId) {
    return jpaQueryFactory
        .select(booking)
        .from(booking)
        .where(booking.state.in(BookingType.WAITING,BookingType.COLLING))
        .where(booking.shopId.eq(shopId))
        .orderBy(booking.ticketNumber.asc())
        .fetch();
  }
}
