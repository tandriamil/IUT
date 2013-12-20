-- Les tables pour les pates

CREATE TABLE Pates (
	idPate int(3) PRIMARY KEY AUTO_INCREMENT,
	pate VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypePates (
	idTypePate int(3) PRIMARY KEY AUTO_INCREMENT,
	typePate VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE PateTypePate (
	idPateTypePate int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdPate int(3) NOT NULL,
	refIdTypePate int(3) NOT NULL,
	FOREIGN KEY (refIdPate) REFERENCES Pates(idPate),
	FOREIGN KEY (refIdTypePate) REFERENCES TypePates(idTypePate)
);