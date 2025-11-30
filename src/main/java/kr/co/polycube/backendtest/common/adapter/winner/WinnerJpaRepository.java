package kr.co.polycube.backendtest.common.adapter.winner;

import kr.co.polycube.backendtest.domain.winner.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnerJpaRepository extends JpaRepository<Winner, Long> {

}
