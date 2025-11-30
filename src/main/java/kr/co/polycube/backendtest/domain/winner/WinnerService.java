package kr.co.polycube.backendtest.domain.winner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kr.co.polycube.backendtest.common.util.LottoUtil;
import kr.co.polycube.backendtest.domain.lotto.Lotto;
import kr.co.polycube.backendtest.domain.lotto.LottoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WinnerService {
  private final WinnerRepositoryPort winnerRepository;

  @Transactional
  public void saveWinners(Map<Lotto, Integer> lottos){
    List<Winner> winners = new ArrayList<>();
    for(Entry<Lotto, Integer> entry : lottos.entrySet()){
      winners.add(new Winner(entry.getKey(), entry.getValue()));
    }

    winnerRepository.saveAll(winners);
  }
}
