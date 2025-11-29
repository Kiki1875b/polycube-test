package kr.co.polycube.backendtest.common.adapter.user;

import java.util.Optional;
import kr.co.polycube.backendtest.domain.user.User;
import kr.co.polycube.backendtest.domain.user.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepositoryPort {

  private final UserJpaRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }
}
