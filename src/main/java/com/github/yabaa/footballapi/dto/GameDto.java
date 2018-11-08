package com.github.yabaa.footballapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
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

    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @ApiModelProperty(dataType = "date", example = "01/01/2017")
    LocalDate startDate;
}
