import java.io.*;
import java.net.*;

public class Serveur {
   static final int port = 8080;

   public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        Socket soc = s.accept();

        // Un BufferedReader permet de lire par ligne.
        BufferedReader plec = new BufferedReader(
                               new InputStreamReader(soc.getInputStream())
                              );

        // Un PrintWriter possède toutes les opérations print classiques.
        // En mode auto-flush, le tampon est vidé (flush) à l'appel de println.
        PrintWriter pred = new PrintWriter(
                             new BufferedWriter(
                                new OutputStreamWriter(soc.getOutputStream())), 
                             true);

        while (true) {
           String str = plec.readLine();          // lecture du message
           if (str.equals("END")) break;
           System.out.println("ECHO = " + str);   // trace locale
           pred.println(str);                     // renvoi d'un écho
        }
        plec.close();
        pred.close();
        soc.close();
   }
}