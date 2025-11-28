package kr.co.polycube.backendtest.common.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    @NotBlank(message = "빈 이름은 허용되지 않습니다.")
    String name
) {
}
