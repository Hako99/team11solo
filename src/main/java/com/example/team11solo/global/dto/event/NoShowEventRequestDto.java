package com.example.team11solo.global.dto.event;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class NoShowEventRequestDto {

  private LocalDateTime now;

  public NoShowEventRequestDto(LocalDateTime now){
    this.now = now;
  }


}
