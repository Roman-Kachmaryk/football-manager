package testtask.footballmanager.mapper;

import org.springframework.stereotype.Component;
import testtask.footballmanager.dto.request.FootballClubRequestDto;
import testtask.footballmanager.dto.response.FootballClubResponseDto;
import testtask.footballmanager.model.FootballClub;
import testtask.footballmanager.service.FootballClubService;

@Component
public class FootballClubMapper {
    private final FootballClubService footballClubService;

    public FootballClubMapper(FootballClubService footballClubService) {
        this.footballClubService = footballClubService;
    }

    public FootballClubResponseDto mapToDto(FootballClub footballClub) {
        FootballClubResponseDto footballClubResponseDto
                = new FootballClubResponseDto();
        footballClubResponseDto.setId(footballClub.getId());
        footballClubResponseDto.setName(footballClub.getName());
        footballClubResponseDto.setCommissionRate(footballClub.getCommissionRate());
        footballClubResponseDto.setBankAccountBalance(footballClub.getBankAccountBalance());
        return footballClubResponseDto;
    }

    public FootballClub mapToModel(FootballClubRequestDto dto) {
        FootballClub footballClub = new FootballClub();
        footballClub.setName(dto.getName());
        footballClub.setCommissionRate(dto.getCommissionRate());
        footballClub.setBankAccountBalance(dto.getBankAccountBalance());
        return footballClub;
    }
}
