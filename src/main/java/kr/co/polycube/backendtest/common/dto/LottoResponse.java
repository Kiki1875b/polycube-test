package kr.co.polycube.backendtest.common.dto;

import kr.co.polycube.backendtest.domain.lotto.Lotto;

public record LottoResponse(int[] numbers) {
  public static LottoResponse from(Lotto lotto){
    return new LottoResponse(lotto.toArray());
  }
}
