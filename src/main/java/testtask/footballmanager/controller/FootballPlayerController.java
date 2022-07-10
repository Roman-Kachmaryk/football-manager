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
import testtask.footballmanager.dto.request.FootballPlayerRequestDto;
import testtask.footballmanager.dto.response.FootballPlayerResponseDto;
import testtask.footballmanager.mapper.FootballPlayerMapper;
import testtask.footballmanager.model.FootballPlayer;
import testtask.footballmanager.service.FootballPlayerService;

@RestController
@RequestMapping("/football-players")
public class FootballPlayerController {
    private final FootballPlayerService footballPlayerService;
    private final FootballPlayerMapper footballPlayerMapper;

    public FootballPlayerController(FootballPlayerService footballPlayerService,
                                    FootballPlayerMapper footballPlayerMapper) {
        this.footballPlayerService = footballPlayerService;
        this.footballPlayerMapper = footballPlayerMapper;
    }

    @GetMapping
    public List<FootballPlayerResponseDto> findAll() {
        return footballPlayerService.findAll().stream()
                .map(footballPlayerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FootballPlayerResponseDto findById(@PathVariable Long id) {
        return footballPlayerMapper.mapToDto(footballPlayerService.findById(id));
    }

    @PostMapping()
    public FootballPlayerResponseDto create(@RequestBody @Valid FootballPlayerRequestDto dto) {
        return footballPlayerMapper.mapToDto(footballPlayerService.save(
                footballPlayerMapper.mapToModel(dto)));
    }

    @PutMapping("/{id}")
    public FootballPlayerResponseDto update(@PathVariable Long id,
                                            @RequestBody @Valid FootballPlayerRequestDto dto) {
        FootballPlayer footballPlayer = footballPlayerMapper.mapToModel(dto);
        footballPlayer.setId(id);
        return footballPlayerMapper.mapToDto(footballPlayerService.update(footballPlayer));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballPlayerService.delete(id);
    }
}
