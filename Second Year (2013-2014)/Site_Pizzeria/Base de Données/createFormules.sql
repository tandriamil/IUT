-- Les tables pour les Formules
-- A VOIR PLUS TARD!!!

CREATE TABLE Formules (
	idFormule int(3) PRIMARY KEY AUTO_INCREMENT,
	formule VARCHAR(255) NOT NULL,
	composants VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypeFormules (
	idTypeFormule int(3) PRIMARY KEY AUTO_INCREMENT,
	titreFormule VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE FormuleTypeFormule (
	idFormuleTypeFormule int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdFormule int(3) NOT NULL,
	refIdTypeFormule int(3) NOT NULL,
	FOREIGN KEY (refIdFormule) REFERENCES Formules(idFormule),
	FOREIGN KEY (refIdTypeFormule) REFERENCES TypeFormules(idTypeFormule)
);