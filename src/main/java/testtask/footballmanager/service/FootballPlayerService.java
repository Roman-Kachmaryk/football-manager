package testtask.footballmanager.service;

import java.util.List;
import testtask.footballmanager.model.FootballPlayer;

public interface FootballPlayerService {
    FootballPlayer save(FootballPlayer footballPlayer);

    List<FootballPlayer> findAll();

    FootballPlayer findById(Long id);

    FootballPlayer update(FootballPlayer footballPlayer);

    void delete(Long id);
}
