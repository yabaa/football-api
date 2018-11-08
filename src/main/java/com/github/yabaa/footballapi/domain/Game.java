package com.github.yabaa.footballapi.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "outsideTeam", "homeTeam", "startDate" })
public class Game {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "outsideTeamId", insertable = false, updatable = false)
    private Team outsideTeam;

    @OneToOne
    @JoinColumn(name = "homeTeamId", insertable = false, updatable = false)
    private Team homeTeam;

    @NotNull
    private LocalDate startDate;

}
