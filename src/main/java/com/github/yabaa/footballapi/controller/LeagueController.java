package com.github.yabaa.footballapi.controller;

import com.github.yabaa.footballapi.domain.League;
import com.github.yabaa.footballapi.dto.LeagueDto;
import com.github.yabaa.footballapi.mapper.LeagueMapper;
import com.github.yabaa.footballapi.service.LeagueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

import static com.github.yabaa.footballapi.Application.BASE_API_V1_PATH;
import static com.github.yabaa.footballapi.controller.LeagueController.API_PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = API_PATH, produces = { APPLICATION_JSON_VALUE })
@RestController
@Slf4j
public class LeagueController {

    private static final String API_NAME_CA = "leagues";
    static final String API_PATH = BASE_API_V1_PATH + API_NAME_CA;

    private final LeagueService leagueService;
    private final LeagueMapper leagueMapper;

    private LeagueController(LeagueService leagueService, LeagueMapper leagueMapper) {
        this.leagueService = leagueService;
        this.leagueMapper = leagueMapper;
    }

    @GetMapping("/{leagueId}")
    @ApiOperation(
            value = "Get a league by its id.",
            response = ResponseEntity.class,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<LeagueDto> findOne(@PathVariable UUID leagueId) {
        return ResponseEntity.ok(leagueMapper.entityToDto(leagueService.findOne(leagueId)));
    }

    @GetMapping
    @ApiOperation(
            value = "Get array of league.",
            response = ResponseEntity.class,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Set<LeagueDto>> findAll() {
        return ResponseEntity.ok(leagueMapper.entitiesToDtos(leagueService.findAll()));
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new league.",
            response = ResponseEntity.class,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<LeagueDto> create(@RequestBody @Valid LeagueDto leagueDto) {
        League leagueToCreate = leagueMapper.dtoToEntity(leagueDto);
        return ResponseEntity.ok(leagueMapper.entityToDto(leagueService.create(leagueToCreate)));
    }

    @PutMapping("/{leagueId}")
    @ApiOperation(
            value = "Update an existing league.",
            response = ResponseEntity.class,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<LeagueDto> update(@PathVariable UUID leagueId,
                                            @RequestBody @Valid LeagueDto leagueDto) {
        League leagueToUpdate = leagueMapper.dtoToEntity(leagueDto);
        return ResponseEntity.ok(leagueMapper.entityToDto(leagueService.update(leagueId,
                leagueToUpdate)));
    }

}
