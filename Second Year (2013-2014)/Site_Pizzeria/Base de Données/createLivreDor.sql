-- Les messages du livre dor

CREATE TABLE LivreDor (
	idLivreDor int(5) PRIMARY KEY AUTO_INCREMENT,
	auteur VARCHAR(255) NOT NULL,
	emailAuteur VARCHAR(255) NOT NULL,
	dateLivreDor TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	corps TEXT
);