package kr.co.polycube.backendtest.common.api;


import jakarta.validation.Valid;
import kr.co.polycube.backendtest.common.dto.UserCreateResponse;
import kr.co.polycube.backendtest.common.dto.UserRequest;
import kr.co.polycube.backendtest.common.dto.UserResponse;
import kr.co.polycube.backendtest.domain.user.User;
import kr.co.polycube.backendtest.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserCreateResponse> createUser(@Valid @RequestBody UserRequest request){
    User savedUser = userService.createUser(request.name());
    return ResponseEntity.status(HttpStatus.CREATED).body(UserCreateResponse.from(savedUser));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
    User foundUser = userService.getUser(id);
    return ResponseEntity.ok(UserResponse.from(foundUser));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
    User updatedUser = userService.update(id, request.name());
    return ResponseEntity.ok(UserResponse.from(updatedUser));
  }
}
