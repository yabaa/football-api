package com.github.yabaa.footballapi.service;

import com.github.yabaa.footballapi.domain.League;
import com.github.yabaa.footballapi.exception.NotFoundErrorType;
import com.github.yabaa.footballapi.exception.NotFoundException;
import com.github.yabaa.footballapi.mapper.LeagueMapper;
import com.github.yabaa.footballapi.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;

    private LeagueService(LeagueRepository leagueRepository, LeagueMapper leagueMapper) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
    }

    public League findOne(UUID leagueId) {
        return leagueRepository.findById(leagueId)
                .orElseThrow(() -> new NotFoundException(NotFoundErrorType.LEAGUE,
                        new Object[]{ leagueId }));
    }

    public Set<League> findAll() {
        return StreamSupport.stream(leagueRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    public League create(League league) {
        return leagueRepository.save(league);
    }

    public League update(UUID leagueId, League league) {
        return leagueRepository.findById(leagueId)
                .map(existingLeague -> leagueMapper.update(existingLeague, league))
                .orElseThrow(() -> new NotFoundException(NotFoundErrorType.LEAGUE,
                        new Object[]{ leagueId }));
    }

}
