package com.example.team11solo.global.util;

import com.example.team11solo.domain.customer.service.CustomerService;
import com.example.team11solo.global.dto.event.NoShowEventRequestDto;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {
  private final ApplicationEventPublisher publisher;

  //(초 분 시 일 월 년)
  @Scheduled(cron = "0 0/10 * * * ?")
  public void noShowScheduled(){
    publisher.publishEvent(new NoShowEventRequestDto(LocalDate.now().atStartOfDay().minusHours(1)));
  }

}
