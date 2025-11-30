package kr.co.polycube.backendtest.domain.lotto;

import java.util.List;

public interface LottoRepositoryPort {
  Lotto save(Lotto lotto);
  List<Lotto> findAll();
}
