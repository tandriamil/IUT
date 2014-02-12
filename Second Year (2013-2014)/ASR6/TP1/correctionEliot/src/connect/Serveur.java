package connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Serveur {

	private Vector <Client> clients;

	public Serveur(int port) {
		try {
			clients = new Vector<Client>();
			ServerSocket serverSocket = new ServerSocket(port);
			System.err.println("Start server on port: " + port);
			
			for(;;) {
				// On accepte la connection d'un nouveau client
				Socket call = serverSocket.accept();

				System.out.println("Client coming from " + call.getRemoteSocketAddress());
				// On recupère les flux d'entrée et de sortie
				BufferedReader in = new BufferedReader(new InputStreamReader(call.getInputStream()));
				PrintStream out = new PrintStream(call.getOutputStream(), true);
				
				// On créé et ajoute un nouveau client à notre liste
				Client client = new Client(in, out, clients);
				synchronized(clients) {
					clients.add(client);
				}
				
				// On lance le thread du nouveau client
				Thread conv = new Thread(client);
				conv.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}