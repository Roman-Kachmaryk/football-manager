package testtask.footballmanager.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testtask.footballmanager.dto.request.FootballClubRequestDto;
import testtask.footballmanager.dto.response.FootballClubResponseDto;
import testtask.footballmanager.mapper.FootballClubMapper;
import testtask.footballmanager.model.FootballClub;
import testtask.footballmanager.service.FootballClubService;

@RestController
@RequestMapping("/football-clubs")
public class FootballClubController {
    private final FootballClubService footballClubService;
    private final FootballClubMapper footballClubMapper;

    public FootballClubController(FootballClubService footballClubService,
                                  FootballClubMapper footballClubMapper) {
        this.footballClubService = footballClubService;
        this.footballClubMapper = footballClubMapper;
    }

    @GetMapping
    public List<FootballClubResponseDto> findAll() {
        return footballClubService.findAll().stream()
                .map(footballClubMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FootballClubResponseDto findById(@PathVariable Long id) {
        return footballClubMapper.mapToDto(footballClubService.findById(id));
    }

    @PostMapping()
    public FootballClubResponseDto create(@RequestBody @Valid FootballClubRequestDto dto) {
        return footballClubMapper.mapToDto(footballClubService.save(
                footballClubMapper.mapToModel(dto)));
    }

    @PutMapping("/{id}")
    public FootballClubResponseDto update(@PathVariable Long id,
                                           @RequestBody @Valid FootballClubRequestDto dto) {
        FootballClub footballClub = footballClubMapper.mapToModel(dto);
        footballClub.setId(id);
        return footballClubMapper.mapToDto(footballClubService.update(footballClub));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballClubService.delete(id);
    }
}
