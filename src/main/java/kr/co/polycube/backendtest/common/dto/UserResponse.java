package kr.co.polycube.backendtest.common.dto;

import kr.co.polycube.backendtest.domain.user.User;

public record UserResponse(
    Long id,
    String name
) {
  public static UserResponse from(User user) {
    return new UserResponse(user.getId(), user.getName());
  }
}
