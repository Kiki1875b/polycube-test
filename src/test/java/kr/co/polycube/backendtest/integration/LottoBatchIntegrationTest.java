package kr.co.polycube.backendtest.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import kr.co.polycube.backendtest.domain.lotto.Lotto;
import kr.co.polycube.backendtest.domain.lotto.LottoRepositoryPort;
import kr.co.polycube.backendtest.domain.lotto.LottoService;
import kr.co.polycube.backendtest.domain.winner.Winner;
import kr.co.polycube.backendtest.domain.winner.WinnerRepositoryPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class LottoBatchIntegrationTest {
  @Autowired
  LottoService lottoService;
  @Autowired
  WinnerRepositoryPort winnerRepo;
  @Autowired
  LottoRepositoryPort lottoRepo;

  @Test
  void batch_creates_winners_correctly() {
    // given
    Lotto lotto1 = lottoRepo.save(new Lotto(new int[]{1,2,3,4,5,6}));
    Lotto lotto2 = lottoRepo.save(new Lotto(new int[]{1,2,3,4,5,9}));
    Lotto lotto3 = lottoRepo.save(new Lotto(new int[]{10,11,12,13,14,15}));
    int[] winningNumbers = {1,2,3,4,5,6};

    // when
    lottoService.generateWinners(winningNumbers);

    // then
    List<Winner> winners = winnerRepo.findAll();
    List<Integer> ranks = winners.stream().map(Winner::getRank).toList();
    assertThat(winners).hasSize(2);
    assertThat(ranks).containsExactlyInAnyOrder(1,2);
  }

}
