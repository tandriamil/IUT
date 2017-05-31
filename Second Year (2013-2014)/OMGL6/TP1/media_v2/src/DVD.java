package media;

/**
 * The DVD class represents a DVD object. Information about the
 * DVD is stored and can be retrieved. We assume that we only deal
 * with movie DVDs at this stage.
 *
 */
public class DVD extends Item {

    /**
     * Empty constructor
     */
    public DVD() {
        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
    }

    /**
     * Constructor for objects of class DVD
     * @param theTitle The title of this DVD
     * @param theDirector The director of this DVD
     * @param time The running time of the main feature
     * @param theGenre The category of this DVD
     */
    public DVD(String theTitle, String theDirector, int time, Genre theGenre) {
        this.title = theTitle;
        this.artist = theDirector;
        this.playingTime = time;
        this.gotIt = false;
        this.genre = theGenre;
        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
    }


    /**
     * Print details about this DVD to the text terminal.
     */
    public String toString()
    {
        String ret = "";
        ret = ret + "DVD: " + title + " (" + playingTime + " mins)";
        if(gotIt) {
            ret = ret + "*";
        }

        ret = ret + "    " + artist;
        ret = ret + "    " + genre;
        return ret;
    }
}
