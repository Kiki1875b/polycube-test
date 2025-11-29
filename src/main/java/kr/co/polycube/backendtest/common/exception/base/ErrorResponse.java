package kr.co.polycube.backendtest.common.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
  private String reason;

  public static ErrorResponse of(String message) {
    return new ErrorResponse(message);
  }
}
