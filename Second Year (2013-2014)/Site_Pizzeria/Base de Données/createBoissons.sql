-- Les tables pour les Boissons

CREATE TABLE Boissons (
	idBoisson int(3) PRIMARY KEY AUTO_INCREMENT,
	boisson VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypeBoissons (
	idTypeBoisson int(3) PRIMARY KEY AUTO_INCREMENT,
	titreBoisson VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE BoissonTypeBoisson (
	idBoissonTypeBoisson int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdBoisson int(3) NOT NULL,
	refIdTypeBoisson int(3) NOT NULL,
	FOREIGN KEY (refIdBoisson) REFERENCES Boissons(idBoisson),
	FOREIGN KEY (refIdTypeBoisson) REFERENCES TypeBoissons(idTypeBoisson)
);