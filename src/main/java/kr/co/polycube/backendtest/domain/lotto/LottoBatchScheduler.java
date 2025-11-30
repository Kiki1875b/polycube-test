package kr.co.polycube.backendtest.domain.lotto;

import kr.co.polycube.backendtest.common.util.LottoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LottoBatchScheduler {
  private final LottoService lottoService;

  @Scheduled(cron = "0 0 0 * * SUN")
  public void runLottoBatch(){
    int[] winningNumbers = LottoUtil.generateNumbers();
    lottoService.generateWinners(winningNumbers);
  }
}
