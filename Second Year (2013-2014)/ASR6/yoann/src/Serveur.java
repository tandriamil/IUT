import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {

    private int firstPort;
    private int secondPort;
    private String service;

    // Server initialisation : we initialize the server with the port where we do the request, the URL where we want to do the request and the port of the final server (of URL)
    public Serveur(int portServerDevelopper, String serv, int portFinalServer) {
        this.firstPort = portServerDevelopper;
        this.service = serv;
        this.secondPort = portFinalServer;

    // Method allowing to establish the connection between the server's developper and the client
    public void lanceServeur() {
        try {
            // We create a new socket between the developper's server and the client
            ServerSocket serverSocket = new ServerSocket(port);
            System.err.println("Start server on port: " + port);
            
        while (true) {
            // We accept the connection of a new client
            Socket call = serverSocket.accept();

            System.out.println("Client coming from " + call.getRemoteSocketAddress());

            // We collect input and output flows
            BufferedReader in = new BufferedReader(new InputStreamReader(call.getInputStream()));
            PrintStream out = new PrintStream(call.getOutputStream(), true);
                
        //    // We run the Thread of the client
        //    Thread conv = new Thread(client);
        //    conv.start();
        //}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

