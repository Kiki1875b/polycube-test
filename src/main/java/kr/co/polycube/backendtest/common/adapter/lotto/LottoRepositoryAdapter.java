package kr.co.polycube.backendtest.common.adapter.lotto;

import java.util.List;
import kr.co.polycube.backendtest.domain.lotto.Lotto;
import kr.co.polycube.backendtest.domain.lotto.LottoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LottoRepositoryAdapter implements LottoRepositoryPort {

  private final LottoJpaRepository lottoRepository;
  @Override
  public Lotto save(Lotto lotto) {
    return lottoRepository.save(lotto);
  }

  @Override
  public List<Lotto> findAll() {
    return lottoRepository.findAll();
  }
}
