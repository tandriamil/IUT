package mailtab;

public class TestMailItem {
    public static void main (String [] args) {
	//Test Constructeur + getFrom() + getTo() + getMessage()
	MailItem mailitem1 = new MailItem ("Roger", "Jean-Pierre", "Ah que coucou ça va?");

	System.out.println ("L'expéditeur est: " + mailitem1.getFrom() + ".");
	System.out.println ("Le destinataire est: " + mailitem1.getTo() + ".");
	System.out.println ("Le message est: " + mailitem1.getMessage());

	//Test affichage du message
	System.out.println ('\n' + mailitem1.enChaine());
    }
}