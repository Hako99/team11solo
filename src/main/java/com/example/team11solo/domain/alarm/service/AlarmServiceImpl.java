package com.example.team11solo.domain.alarm.service;

import com.example.team11solo.domain.alarm.repository.AlarmSseEmitterRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
@Transactional
public class AlarmServiceImpl implements AlarmService {

  private final AlarmSseEmitterRepository alarmSseEmitterRepository;
  private static final Long DEFAULT_TIMEOUT = 600L * 1000 * 60;

  @Override
  public SseEmitter subscribe(Long id) {
    SseEmitter emitter = createEmitter(id);
    sendToClient(id, id + " 번 유저의 줄서기가 시작되었습니다.");
    return emitter;
  }

  @Override
  public SseEmitter createEmitter(Long userId) {
    SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
    alarmSseEmitterRepository.save(userId, emitter);

    emitter.onCompletion(() -> alarmSseEmitterRepository.deleteById(userId));
    emitter.onTimeout(() -> alarmSseEmitterRepository.deleteById(userId));

    return emitter;
  }

  @Override
  public void sendToClient(Long userId, Object data) {
    SseEmitter emitter = alarmSseEmitterRepository.get(userId);
    if (emitter != null) {
      try {
        emitter.send(SseEmitter.event()
            .id(String.valueOf(userId))
            .name("sse")
            .data(data)
            .comment("sse 접속 성공"));
      } catch (IOException e) {
        alarmSseEmitterRepository.deleteById(userId);
        emitter.completeWithError(e);
      }
    }
  }

  @Override
  public void sendMessage(Long userId, String message) {
    SseEmitter emitter = alarmSseEmitterRepository.get(userId);
    try {
      emitter.send(SseEmitter.event()
          .name(userId+"번 손님")
          .data(message));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public void alarmClose(Long userId){
    SseEmitter emitter = alarmSseEmitterRepository.get(userId);
    emitter.complete();
  }
}
