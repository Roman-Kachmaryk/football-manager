package testtask.footballmanager.service.impl;

import java.math.BigDecimal;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import testtask.footballmanager.dto.request.TransferRequestDto;
import testtask.footballmanager.model.FootballClub;
import testtask.footballmanager.model.FootballPlayer;
import testtask.footballmanager.service.FootballClubService;
import testtask.footballmanager.service.FootballPlayerService;
import testtask.footballmanager.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
    private final FootballPlayerService footballPlayerService;
    private final FootballClubService footballClubService;

    public TransferServiceImpl(FootballPlayerService footballPlayerService,
                               FootballClubService footballClubService) {
        this.footballPlayerService = footballPlayerService;
        this.footballClubService = footballClubService;
    }

    @Transactional
    @Override
    public String transfer(TransferRequestDto dto) {
        FootballPlayer footballPlayer
                = footballPlayerService.findById(dto.getFootballPlayerId());
        FootballClub fromFootballClub =
                footballClubService.findById(dto.getFromFootballClubId());
        FootballClub toFootballClub =
                footballClubService.findById(dto.getToFootballClubId());

        if (fromFootballClub.equals(toFootballClub)) {
            throw new RuntimeException("Football player can't sign for the same club");
        }

        int transferPrice = (footballPlayer.getExperienceInMonths() * 100000)
                / footballPlayer.getAge();
        transferPrice += (fromFootballClub.getCommissionRate() * transferPrice) / 100;

        if (BigDecimal.valueOf(transferPrice)
                .compareTo(fromFootballClub.getBankAccountBalance()) > 0) {
            throw new RuntimeException("Not enough money for this transaction");
        }
        fromFootballClub.setBankAccountBalance(
                fromFootballClub.getBankAccountBalance().add(BigDecimal.valueOf(transferPrice)));
        footballClubService.update(fromFootballClub);

        toFootballClub.setBankAccountBalance(
                toFootballClub.getBankAccountBalance().subtract(BigDecimal.valueOf(transferPrice)));
        footballClubService.update(toFootballClub);

        footballPlayer.setFootballClub(footballClubService.findById(toFootballClub.getId()));
        footballPlayerService.update(footballPlayer);

        return "Successful transaction!";
    }
}
