-- Les tables pour les Desserts

CREATE TABLE Desserts (
	idDessert int(3) PRIMARY KEY AUTO_INCREMENT,
	dessert VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypeDesserts (
	idTypeDessert int(3) PRIMARY KEY AUTO_INCREMENT,
	titreDessert VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE DessertTypeDessert (
	idDessertTypeDessert int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdDessert int(3) NOT NULL,
	refIdTypeDessert int(3) NOT NULL,
	FOREIGN KEY (refIdDessert) REFERENCES Desserts(idDessert),
	FOREIGN KEY (refIdTypeDessert) REFERENCES TypeDesserts(idTypeDessert)
);