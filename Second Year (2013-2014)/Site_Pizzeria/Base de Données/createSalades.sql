-- Les tables pour les Salades

CREATE TABLE Salades (
	idSalade int(3) PRIMARY KEY AUTO_INCREMENT,
	salade VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypeSalades (
	idTypeSalade int(3) PRIMARY KEY AUTO_INCREMENT,
	titreSalade VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE SaladeTypeSalade (
	idSaladeTypeSalade int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdSalade int(3) NOT NULL,
	refIdTypeSalade int(3) NOT NULL,
	FOREIGN KEY (refIdSalade) REFERENCES Salades(idSalade),
	FOREIGN KEY (refIdTypeSalade) REFERENCES TypeSalades(idTypeSalade)
);