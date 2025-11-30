package kr.co.polycube.backendtest.domain.winner;

import java.util.List;

public interface WinnerRepositoryPort {
  Winner save(Winner winner);
  List<Winner> saveAll(List<Winner> winners);
  List<Winner> findAll();
}
