CREATE TABLE league (
  id UUID  NOT NULL,
  name VARCHAR(100) NOT NULL,
  country VARCHAR(50) NOT NULL,
  CONSTRAINT league_pkey PRIMARY KEY (id),
  CONSTRAINT uk_league UNIQUE (name, country)
);

CREATE TABLE team (
  id UUID  NOT NULL,
  name VARCHAR(100) NOT NULL,
  league_id UUID,
  CONSTRAINT team_pkey PRIMARY KEY (id),
  CONSTRAINT fk_team_1 FOREIGN KEY (league_id) REFERENCES league (id) MATCH SIMPLE,
  CONSTRAINT uk_team UNIQUE (name, league_id)
);

CREATE TABLE game (
  id UUID  NOT NULL,
  outside_team_id UUID,
  home_team_id UUID,
  start_date DATE,
  CONSTRAINT game_pkey PRIMARY KEY (id),
  CONSTRAINT fk_game_1 FOREIGN KEY (outside_team_id) REFERENCES team (id) MATCH SIMPLE,
  CONSTRAINT fk_game_2 FOREIGN KEY (home_team_id) REFERENCES team (id) MATCH SIMPLE,
  CONSTRAINT uk_game UNIQUE (outside_team_id, home_team_id, start_date)
);
