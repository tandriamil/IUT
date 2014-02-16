import java.io.*;
import java.net.*;

public class ClientServer implements Runnable {

	private Socket socket;

	public ClientServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = this.socket.getInputStream();
			InputStreamReader stream = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(stream);
			String request = buffer.readLine();
			String[] requestTab = request.split(":");
			if(requestTab[0].equals("GET")){
				//Traitement de la requete
				
			}
			else {
				System.out.println("Erreur, seulement les requetes GET sont traites dans ce TP");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
