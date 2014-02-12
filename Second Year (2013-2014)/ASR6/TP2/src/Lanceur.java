/**
 * The class to launch the application
 */
public class Lanceur {

	/**
	 * The main method to run the application
	 */
	public static void main(String[] args) {
		int port = 0;

		try {
			port = Integer.parseInt(args[0]);
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Port number non entered.");
		}

		//Creates the server
		Serveur serv = new Serveur(port);

		System.out.println("Lancement de l'application sur le port " + port + "." + "\n" + "################################################");

		//Then waits some connection
		serv.waitConnection();

		//When finished, close it
		serv.closeServer();
	}

}