CREATE TABLE IF NOT EXISTS CI_SESSIONS (
	session_id      varchar(40)    DEFAULT '0' PRIMARY KEY,
	ip_address      varchar(16)    DEFAULT '0' NOT NULL,
	user_agent      varchar(120)   NOT NULL,
	last_activity   int(10)        unsigned DEFAULT 0 NOT NULL,
	user_data       text           NOT NULL,

	KEY `last_activity_idx` (`last_activity`)
);