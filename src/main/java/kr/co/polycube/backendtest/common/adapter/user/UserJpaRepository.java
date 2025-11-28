package kr.co.polycube.backendtest.common.adapter.user;

import kr.co.polycube.backendtest.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
