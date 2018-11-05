package com.github.yabaa.footballapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDto {

    UUID id;

    @NonNull
    TeamDto homeTeam;

    @NonNull
    TeamDto outsideTeam;
}
