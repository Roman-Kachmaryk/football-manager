package testtask.footballmanager.mapper;

import org.springframework.stereotype.Component;
import testtask.footballmanager.dto.request.FootballPlayerRequestDto;
import testtask.footballmanager.dto.response.FootballPlayerResponseDto;
import testtask.footballmanager.model.FootballPlayer;
import testtask.footballmanager.service.FootballClubService;
import testtask.footballmanager.service.FootballPlayerService;

@Component
public class FootballPlayerMapper {
    private final FootballPlayerService footballPlayerService;
    private final FootballClubService footballClubService;

    public FootballPlayerMapper(FootballPlayerService footballPlayerService,
                                FootballClubService footballClubService) {
        this.footballPlayerService = footballPlayerService;
        this.footballClubService = footballClubService;
    }

    public FootballPlayerResponseDto mapToDto(FootballPlayer footballPlayer) {
        FootballPlayerResponseDto footballPlayerResponseDto
                = new FootballPlayerResponseDto();
        footballPlayerResponseDto.setId(footballPlayer.getId());
        footballPlayerResponseDto.setName(footballPlayer.getName());
        footballPlayerResponseDto.setAge(footballPlayer.getAge());
        footballPlayerResponseDto.setExperienceInMonths(footballPlayer.getExperienceInMonths());
        footballPlayerResponseDto.setFootballClubId(footballPlayer.getFootballClub().getId());
        return footballPlayerResponseDto;
    }

    public FootballPlayer mapToModel(FootballPlayerRequestDto dto) {
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.setName(dto.getName());
        footballPlayer.setAge(dto.getAge());
        footballPlayer.setExperienceInMonths(dto.getExperienceInMonths());
        footballPlayer.setFootballClub(footballClubService.findById(dto.getFootballClubId()));
        return footballPlayer;
    }
}
