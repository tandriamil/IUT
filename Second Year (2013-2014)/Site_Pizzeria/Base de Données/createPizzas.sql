-- Les tables pour les pizzas

CREATE TABLE Pizzas (
	idPizza int(3) PRIMARY KEY AUTO_INCREMENT,
	pizza VARCHAR(255) NOT NULL,
	prix1 VARCHAR(255) NOT NULL,
	prix2 VARCHAR(255),
	prix3 VARCHAR(255)
);


CREATE TABLE TypePizzas (
	idTypePizza int(3) PRIMARY KEY AUTO_INCREMENT,
	typePizza VARCHAR(255),
	texteAuDessus VARCHAR(255),
	texteEnDessous VARCHAR(255),
	titrePrix1 VARCHAR(255) NOT NULL,
	titrePrix2 VARCHAR(255),
	titrePrix3 VARCHAR(255)
);


CREATE TABLE PizzaTypePizza (
	idPizzaTypePizza int(3) PRIMARY KEY AUTO_INCREMENT,
	refIdPizza int(3) NOT NULL,
	refIdTypePizza int(3) NOT NULL,
	FOREIGN KEY (refIdPizza) REFERENCES Pizzas(idPizza),
	FOREIGN KEY (refIdTypePizza) REFERENCES TypePizzas(idTypePizza)
);