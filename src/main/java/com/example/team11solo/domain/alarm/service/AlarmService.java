package com.example.team11solo.domain.alarm.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface AlarmService {

  SseEmitter subscribe(Long id);
  SseEmitter createEmitter(Long userId);
  void sendToClient(Long userId, Object data);
  void sendMessage (Long userId, String message);
   void alarmClose(Long userId);

}
