package kr.co.polycube.backendtest.domain.user;

import java.util.Optional;

public interface UserRepositoryPort {
  User save(User user);
  Optional<User> findById(Long id);
}
