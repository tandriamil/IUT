package mailtab;

public class TestMailServer {
    public static void main (String [] args) {
	//Test Constructeur  //Fonctionne
	MailServer server = new MailServer();
	MailItem mail1 = new MailItem ("Bernard","Roger","Yes Mon Gars!!!");
	MailItem mail3 = new MailItem ("Roger","Bernard","Trololol!");
	MailItem mail2 = new MailItem ("Autre","Roger","Message 3");
	MailItem temp;

	//Test post  //Fonctionne
	server.post(mail1);
	server.post(mail2);
	server.post(mail3);

	//Test howManyMailItems  //Fontcionne
	System.out.println(mail1.getTo() + " a reçu " + server.howManyMailItems(mail1.getTo()) + " message(s).");
	System.out.println(mail3.getTo() + " a reçu " + server.howManyMailItems(mail3.getTo()) + " message(s).");

	//Test getNextMailItem
	temp = server.getNextMailItem("Roger");
	System.out.println('\n' + temp.enChaine());
	System.out.println('\n' + "Maintenant, " + mail2.getTo() + " a " + server.howManyMailItems(mail2.getTo()) + " message(s) dans le serveur.");

	temp = server.getNextMailItem("Roger");
	System.out.println('\n' + temp.enChaine());
	System.out.println('\n' + "Maintenant, " + mail2.getTo() + " a " + server.howManyMailItems(mail2.getTo()) + " message(s) dans le serveur.");

	temp = server.getNextMailItem("Roger");
	System.out.println('\n' + temp.enChaine());
	System.out.println('\n' + "Maintenant, " + mail2.getTo() + " a " + server.howManyMailItems(mail2.getTo()) + " message(s) dans le serveur.");

    }
}
