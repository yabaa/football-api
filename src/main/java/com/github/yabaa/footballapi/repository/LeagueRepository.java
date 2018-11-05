package com.github.yabaa.footballapi.repository;

import com.github.yabaa.footballapi.domain.League;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LeagueRepository extends CrudRepository<League, UUID> {

}
