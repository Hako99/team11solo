package com.example.team11solo.global.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto<T> {

  private Integer statusCode;
  private T data;

}
