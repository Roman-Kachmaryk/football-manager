package testtask.footballmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testtask.footballmanager.model.FootballPlayer;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Long> {
}
