package kr.co.polycube.backendtest.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.co.polycube.backendtest.common.util.LottoUtil;
import kr.co.polycube.backendtest.domain.winner.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LottoBasicService implements LottoService{

  private final LottoRepositoryPort lottoRepository;
  private final WinnerService winnerService;
  public Lotto generateLotto(){
    int[] numbers = LottoUtil.generateNumbers();
    Lotto lotto = new Lotto(numbers);
    return lottoRepository.save(lotto);
  }

  @Override
  @Transactional
  public void generateWinners(int[] winningNumbers) {
    List<Lotto> lottos = lottoRepository.findAll();

    Map<Lotto, Integer> lottoRanks = new HashMap<>();

    for(Lotto lotto : lottos) {
      int rank = LottoUtil.toRank(LottoUtil.countMatched(winningNumbers, lotto.toArray()));
      if(rank != 0) {
        lottoRanks.put(lotto, rank);
      }
    }

    winnerService.saveWinners(lottoRanks);
  }
}
