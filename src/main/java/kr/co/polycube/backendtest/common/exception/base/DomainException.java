package kr.co.polycube.backendtest.common.exception.base;

import lombok.Getter;

@Getter
public class DomainException extends IllegalArgumentException {
  private final ErrorCode errorCode;

  public DomainException(ErrorCode code){
    super(code.getMessage());
    this.errorCode = code;
  }
}
