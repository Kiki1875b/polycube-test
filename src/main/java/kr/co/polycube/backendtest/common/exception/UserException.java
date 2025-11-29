package kr.co.polycube.backendtest.common.exception;

import kr.co.polycube.backendtest.common.exception.base.DomainException;
import kr.co.polycube.backendtest.common.exception.base.ErrorCode;
import lombok.Getter;

@Getter
public class UserException extends DomainException {

  public UserException(ErrorCode code) {
    super(code);
  }
}
