package mailtab;

public class TestMailClient {
    public static void main(String [] args) {
	//Test Constructeur + sendMailItem
	MailServer server = new MailServer();
	MailClient client1 = new MailClient (server,"Roger");
	MailClient client2 = new MailClient (server,"Bernard");
	client2.sendMailItem ("Roger", "C'est un sendMailItem!");

	//Test prinNextMailItem
	client1.printNextMailItem();
    }
}