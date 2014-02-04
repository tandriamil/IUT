import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The client class
 */
public class Client {
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        
        //Creates and initialises the socket to default
        Socket socket = new Socket();

        //Gets the port
        int numPort = Integer.parseInt(args[0]);



        //Try to creates the socket and catches error if there are some
        try {
            socket = new Socket(InetAddress.getLocalHost(), numPort);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the client socket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        catch (SecurityException e) {
            System.out.println("SecurityException catched when initializing the client socket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        //If the connection successed
        System.out.println ("Connexion au serveur réussie!");



        //Then closes the socket
        try {
            socket.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the client socket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Le Socket client est correctement fermé.");
    }
}