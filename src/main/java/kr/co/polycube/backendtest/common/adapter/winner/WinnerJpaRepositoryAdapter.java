package kr.co.polycube.backendtest.common.adapter.winner;

import java.util.List;
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

  @Override
  public List<Winner> saveAll(List<Winner> winners) {
    return winnerRepository.saveAll(winners);
  }

  @Override
  public List<Winner> findAll() {
    return winnerRepository.findAll();
  }
}
