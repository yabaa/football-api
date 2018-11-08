package com.github.yabaa.footballapi.mapper;

import com.github.yabaa.footballapi.domain.League;
import com.github.yabaa.footballapi.domain.Team;
import com.github.yabaa.footballapi.dto.TeamDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LeagueMapper.class)
public interface TeamMapper {

    Team dtoToEntity(TeamDto source);

    TeamDto entityToDto(Team source);

}
