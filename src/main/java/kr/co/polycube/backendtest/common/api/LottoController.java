package kr.co.polycube.backendtest.common.api;

import kr.co.polycube.backendtest.common.dto.LottoResponse;
import kr.co.polycube.backendtest.domain.lotto.Lotto;
import kr.co.polycube.backendtest.domain.lotto.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottos")
@RequiredArgsConstructor
public class LottoController {

  private final LottoService lottoService;

  @PostMapping
  public ResponseEntity<LottoResponse> generateLotto(){
    Lotto lotto = lottoService.generateLotto();
    return ResponseEntity.ok(LottoResponse.from(lotto));
  }
}
