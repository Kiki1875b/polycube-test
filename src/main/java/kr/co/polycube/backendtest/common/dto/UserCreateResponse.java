package kr.co.polycube.backendtest.common.dto;

import kr.co.polycube.backendtest.domain.user.User;

public record UserCreateResponse(
    Long id
) {
  public static UserCreateResponse from(User user){
    return new UserCreateResponse(user.getId());
  }
}
