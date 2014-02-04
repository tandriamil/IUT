import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The client class
 */
public class Client {
    
    public static void main(String[] args) {
        
        //Creates the socket
        Socket socket;

        //Gets the port
        int numPort = Integer.parseInt(args[0]);

        try {
            socket = new Socket(InetAddress.getLocalHost(), numPort); 
            System.out.println ("Connexion au serveur réussie !");
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