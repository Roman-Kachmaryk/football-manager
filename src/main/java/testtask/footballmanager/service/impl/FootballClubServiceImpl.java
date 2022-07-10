package testtask.footballmanager.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import testtask.footballmanager.model.FootballClub;
import testtask.footballmanager.repository.FootballClubRepository;
import testtask.footballmanager.service.FootballClubService;

@Service
public class FootballClubServiceImpl implements FootballClubService {
    private final FootballClubRepository footballClubRepository;

    public FootballClubServiceImpl(FootballClubRepository footballClubRepository) {
        this.footballClubRepository = footballClubRepository;
    }

    @Override
    public FootballClub save(FootballClub footballClub) {
        return footballClubRepository.save(footballClub);
    }

    @Override
    public List<FootballClub> findAll() {
        return footballClubRepository.findAll();
    }

    @Override
    public FootballClub findById(Long id) {
        return footballClubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("football club with such an id not found"));
    }

    @Override
    public FootballClub update(FootballClub footballClub) {
        FootballClub footballClubFromDB = footballClubRepository.findById(
                footballClub.getId())
                .orElseThrow(() -> new RuntimeException("football club with such an id not found"));
        footballClubFromDB.setName(footballClub.getName());
        footballClubFromDB.setCommissionRate(footballClub.getCommissionRate());
        footballClubFromDB.setBankAccountBalance(footballClub.getBankAccountBalance());
        return footballClubRepository.save(footballClubFromDB);
    }

    @Override
    public void delete(Long id) {
        footballClubRepository.deleteById(id);
    }
}
