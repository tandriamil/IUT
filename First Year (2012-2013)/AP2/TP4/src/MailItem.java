package mailtab;

public class MailItem {
//Attributs
    private String from;
    private String to;
    private String message;


//Constructeur
    public MailItem (String from, String to, String message) {
	this.from = from;
	this.to = to;
	this.message = message;
    }



//Accesseurs
    public String getFrom() {
	return this.from;
    }


    public String getTo() {
	return this.to;
    }


    public String getMessage() {
	return this.message;
    }


    //Affichage du message
    public String enChaine() {
	String ret;

	ret = "";
	ret = ret + "Le message est envoyé par " + this.from + " à " + this.to + "." + '\n' + "Le contenu du message est:" + '\n' + this.message;
	return ret;
    }
}
