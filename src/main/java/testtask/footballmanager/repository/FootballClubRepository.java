package testtask.footballmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testtask.footballmanager.model.FootballClub;

@Repository
public interface FootballClubRepository extends JpaRepository<FootballClub, Long> {
}
