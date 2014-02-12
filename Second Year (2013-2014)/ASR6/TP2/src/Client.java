import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Thread;


/**
 * The client class
 */
public class Client extends Thread {
//Attributes
    private int numPort;
    private String name;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;


//Methods
    /**
     * The constructor
     */
    public Client(int port) {
        this.numPort = port;

        //Try to creates the socket and catches error if there are some
        try {
            this.socket = new Socket(InetAddress.getLocalHost(), numPort);
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
        System.out.println ("Client correctly created.");



        //Creates the printer-out to transmit messages to the server, auto flush actived
        try {
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the print writer: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("PrintWriter correctly created.");



        //Creates the reader to get an enterred message
        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the buffer: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("BufferedReader correctly created.");
    }



    /**
     * Permits to read a line
     */
    public void read() {
        //read lines then
        try {
            String message = this.in.readLine();
            this.out.println(message);
        }

        catch (IOException e) {
            System.out.println("IOException catched when trying to read: " + "\n" + e.getMessage());
            e.printStackTrace();
        }
    }



    /**
     * Permits to close the reader/writer and the socket
     */
    public void closeAll() {
        //Closes the reader/writer
        try {
            this.in.close();
            this.out.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing in and out: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Reader/Writer correctly closed.");



        //Then closes the socket
        try {
            this.socket.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the client socket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Socket correctly closed.");
    }
}