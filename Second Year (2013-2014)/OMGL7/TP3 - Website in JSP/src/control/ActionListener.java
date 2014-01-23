package control;

import javax.servlet.http.*;

/**
 *
 * @author lesommer
 */
public interface ActionListener {
   
    /**
     * Cette méthode traite la requête HTTP, et sauvegarde,le cas échéant, des
     * données dans la requête via la méthode
     * <code>setAttribute(cle,valeur)</code> afin de partager des données avec
     * la page JSP chargée d'afficher ces données. Cette page JSP peut obtenir
     * ces données via <code>request.getAttribute(cle)</code>.
     */
    public void handle(HttpServletRequest request);
   
}
