package kr.co.polycube.backendtest.domain.user;

import kr.co.polycube.backendtest.common.exception.base.ErrorCode;
import kr.co.polycube.backendtest.common.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepositoryPort userRepositoryPort;

  public User createUser(String name){
    User user = new User(name);
    return userRepositoryPort.save(user);
  }

  public User getUser(Long id){
    return findOrThrowUser(id);
  }

  public User update(Long id, String name){
    User user = findOrThrowUser(id);
    user.updateName(name);
    return userRepositoryPort.save(user);
  }

  private User findOrThrowUser(Long id){
    return userRepositoryPort.findById(id)
        .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
  }
}
