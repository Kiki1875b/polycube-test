package kr.co.polycube.backendtest.domain.lotto;

import java.util.List;

public interface LottoService {
  Lotto generateLotto();

  void generateWinners(int[] winningNumbers);
}
