package com.github.yabaa.footballapi.repository;

import com.github.yabaa.footballapi.domain.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<Game, UUID> {
}
