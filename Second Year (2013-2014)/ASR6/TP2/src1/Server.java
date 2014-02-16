import java.io.*;
import java.net.*;

public class Server {

	public Server() {
		
	}

	public void listen(){
		ServerSocket sso = null;
		try {
			sso = new ServerSocket(80);
			while(sso != null){
				Socket socket = sso.accept();
				ClientServer clientServer = new ClientServer(socket);
				Thread th = new Thread(clientServer);
				th.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
