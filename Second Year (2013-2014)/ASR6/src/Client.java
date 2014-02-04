import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    
    public static void main(String[] zero) {


        Socket socket; // socket entre le client et le serveur
        BufferedReader in; // buffer in pour récupérer des messages
        PrintWriter out; // printer out pour envoyer des messages

        try {
            
            // demande de connexion sur le port 1234
            socket = new Socket(InetAddress.getLocalHost(),1234);   
            System.out.println("Demande de connexion");

            // création d'un printer-out pour transmettre un message au server
            out = new PrintWriter(socket.getOutputStream());
            out.println("message du client : connexion établie !");
            out.flush();

            // création du lecteur pour récupérer un éventuel message venant du server
            in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            String message_distant = in.readLine();
            System.out.println(message_distant);
            
            // fermeture du socket     
            socket.close();
               
        }

        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        catch (IOException e) {   
            e.printStackTrace();
        }
    }
}