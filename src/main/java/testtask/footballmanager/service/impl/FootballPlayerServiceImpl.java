package testtask.footballmanager.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import testtask.footballmanager.model.FootballPlayer;
import testtask.footballmanager.repository.FootballPlayerRepository;
import testtask.footballmanager.service.FootballPlayerService;

@Service
public class FootballPlayerServiceImpl implements FootballPlayerService {
    private final FootballPlayerRepository footballPlayerRepository;

    public FootballPlayerServiceImpl(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    @Override
    public FootballPlayer save(FootballPlayer footballPlayer) {
        return footballPlayerRepository.save(footballPlayer);
    }

    @Override
    public List<FootballPlayer> findAll() {
        return footballPlayerRepository.findAll();
    }

    @Override
    public FootballPlayer findById(Long id) {
        return footballPlayerRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException(
                                "football player with such an id not found"));
    }

    @Override
    public FootballPlayer update(FootballPlayer footballPlayer) {
        FootballPlayer footballPlayerFromDB = footballPlayerRepository.findById(
                footballPlayer.getId()).orElseThrow(() -> new RuntimeException(
                        "football player with such an id not found"));
        footballPlayerFromDB.setName(footballPlayer.getName());
        footballPlayerFromDB.setAge(footballPlayer.getAge());
        footballPlayerFromDB.setExperienceInMonths(footballPlayer.getExperienceInMonths());
        footballPlayerFromDB.setFootballClub(footballPlayer.getFootballClub());
        return footballPlayerRepository.save(footballPlayerFromDB);
    }

    @Override
    public void delete(Long id) {
        footballPlayerRepository.deleteById(id);
    }
}
