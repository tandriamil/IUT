/* The tables for the tuto */
/* The users */
CREATE TABLE IF NOT EXISTS Utilisateurs (
	id INT(10)
	NOT NULL
	AUTO_INCREMENT,

	nom VARCHAR(30),

	age INT(11),

	PRIMARY KEY (id)
)ENGINE=InnoDB;