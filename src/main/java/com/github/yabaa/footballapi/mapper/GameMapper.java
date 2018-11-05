package com.github.yabaa.footballapi.mapper;

import com.github.yabaa.footballapi.domain.Game;
import com.github.yabaa.footballapi.dto.GameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    Game dtoToEntity(GameDto source);

    GameDto entityToDto(Game source);

}
