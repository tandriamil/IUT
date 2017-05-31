package control.listeners;

import javax.servlet.http.*;
import db.*;
import control.*;
import java.sql.Date;

public class AccountCreationListener implements ActionListener {

  public void handle(HttpServletRequest request) {
    request.setAttribute("data", "AccountCreationListener");

    //Recuperation des resultats des requetes
    String nom = (String)request.getAttribute("nom");
    String prenom = (String)request.getAttribute("prenom");
    Date date = (Date)request.getAttribute("dateDeNaissance");
	String email = (String)request.getAttribute("email");
	String adresse = (String)request.getAttribute("adresse");
	int codePostal = (int)request.getAttribute("codePostal");
	String ville = (String)request.getAttribute("ville");
	int pays = (int)request.getAttribute("pays");
	String login = (String)request.getAttribute("login");
	String mdp = (String)request.getAttribute("motDePasse");

	//Creation de l'objet Client
	Client client = new Client();
	ClientDAO cDAO = new ClientDAO();
	client.init(login, mdp, nom, prenom, date, email, adresse, codePostal, ville, pays);

	//Tentative d'insertion du client dans la bdd
	try {
		//Si tout se passe bien
		cDAO.insert(client);
		request.setAttribute("validationCreation", "compteValide");
	}
	catch(Exception e) {
		//Si une erreur survient
		System.out.println(e.getMessage());
		request.setAttribute("validationCreation", "compteInvalide");
	}
  }
}
