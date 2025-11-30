package kr.co.polycube.backendtest.common.adapter.winner;

import kr.co.polycube.backendtest.domain.winner.Winner;
import kr.co.polycube.backendtest.domain.winner.WinnerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WinnerJpaRepositoryAdapter implements WinnerRepositoryPort {
  private final WinnerJpaRepository winnerRepository;

  @Override
  public Winner save(Winner winner) {
    return winnerRepository.save(winner);
  }
}
