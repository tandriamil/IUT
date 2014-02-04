import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The client class
 */
public class Client {
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        
        //Creates and initialises the socket to default
        Socket socket = null;

        //Gets the port
        int numPort = Integer.parseInt(args[0]);

        //Creates the buffer and the writer to send/receive messages
        BufferedReader in = null;
        PrintWriter out = null;



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
        System.out.println ("Demande de connexion ...");



        //Creates the printer-out to transmit messages to the server
        try {
            out = new PrintWriter(socket.getOutputStream());
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the print writer: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        out.println("Connection Client/Serveur établie.");
        out.flush();



        //Creates the reader to get an enterred message
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the buffer: " + "\n" + e.getMessage());
            e.printStackTrace();
        }
        


        //read lines then
        try {
            String message_distant = in.readLine();
            out.println(message_distant);
            out.println("exit");
        }

        catch (IOException e) {
            System.out.println("IOException catched when trying to read: " + "\n" + e.getMessage());
            e.printStackTrace();
        }



        //Closes the reader/writer
        try {
            in.close();
            out.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing in and out: " + "\n" + e.getMessage());
            e.printStackTrace();
        }




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