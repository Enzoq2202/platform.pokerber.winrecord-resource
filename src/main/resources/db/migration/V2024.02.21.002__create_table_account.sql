CREATE TABLE winrecord.win_records
(
    id_winrecord character varying(36) NOT NULL,
    player_id character varying(36) NOT NULL,
    win_time timestamp without time zone NOT NULL,
    win_cards character varying(256) NOT NULL,
    game_type character varying(256),
    CONSTRAINT win_records_pkey PRIMARY KEY (id_winrecord)
);