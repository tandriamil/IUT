-- La table pour les differents donnees du site

CREATE TABLE Donnees (
	idData int(2) PRIMARY KEY,
	titre VARCHAR(50) NOT NULL,
	corps VARCHAR(50)
)

-- La premiere sera pour le mot de passe admin
-- La deuxieme pour le numero de telephone
-- La troisieme pour la plage horaire du lundi
-- Comme ça jusqu'au dimanche