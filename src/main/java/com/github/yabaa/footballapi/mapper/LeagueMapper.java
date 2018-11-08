package com.github.yabaa.footballapi.mapper;

import com.github.yabaa.footballapi.domain.League;
import com.github.yabaa.footballapi.dto.LeagueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface LeagueMapper {

    @Mapping(source = "country", target = "country")
    League dtoToEntity(LeagueDto source);

    LeagueDto entityToDto(League source);

    Set<LeagueDto> entitiesToDtos(Set<League> sources);

    //    @Mapping(target = "id", ignore = true)
    League update(League source, @MappingTarget League target);

}
