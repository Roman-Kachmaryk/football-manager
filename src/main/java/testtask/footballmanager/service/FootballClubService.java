package testtask.footballmanager.service;

import java.util.List;
import testtask.footballmanager.model.FootballClub;

public interface FootballClubService {
    FootballClub save(FootballClub footballClub);

    List<FootballClub> findAll();

    FootballClub findById(Long id);

    FootballClub update(FootballClub footballClub);

    void delete(Long id);
}
