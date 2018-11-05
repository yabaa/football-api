package com.github.yabaa.footballapi.repository;

import com.github.yabaa.footballapi.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {
}
