package kr.co.polycube.backendtest.common.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  // user
  USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "사용자를 찾지 못했습니다.")


  ;


  private final HttpStatus status;
  private final String message;
}
