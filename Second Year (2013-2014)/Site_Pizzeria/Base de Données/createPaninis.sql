-- Les tables pour les Paninis

CREATE TABLE Paninis (
	idPanini int(3) PRIMARY KEY AUTO_INCREMENT,
	panini VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypePaninis (
	idTypePanini int(3) PRIMARY KEY AUTO_INCREMENT,
	titrePanini VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE PaniniTypePanini (
	idPaniniTypePanini int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdPanini int(3) NOT NULL,
	refIdTypePanini int(3) NOT NULL,
	FOREIGN KEY (refIdPanini) REFERENCES Paninis(idPanini),
	FOREIGN KEY (refIdTypePanini) REFERENCES TypePaninis(idTypePanini)
);