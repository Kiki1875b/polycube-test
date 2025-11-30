package kr.co.polycube.backendtest.common.adapter.lotto;

import kr.co.polycube.backendtest.domain.lotto.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoJpaRepository extends JpaRepository<Lotto, Long> {

}
