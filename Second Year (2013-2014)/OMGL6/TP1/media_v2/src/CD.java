package media;

/**
 * The CD class represents a CD object. Information about the 
 * CD is stored and can be retrieved.
 */
public class CD extends Item {
    //Attributes
    private int numberOfTracks;

    /**
     * Empty constructor
     */
    public CD() {
        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
    }

    /**
     * Initialize the CD.
     * @param theTitle The title of the CD.
     * @param theArtist The artist of the CD.
     * @param time The playing time of the CD.
     */
    public CD(String theTitle, String theArtist, int time, Genre theGenre) {
        this.title = theTitle;
        this.artist = theArtist;
        this.playingTime = time;
        this.gotIt = false;
        this.numberOfTracks = 0;
        this.genre = theGenre;

        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
    }


    /**
     * Sets the number of tracks in this album
     * @param n The number of tracks
     */
    public void setTracks(int n) {
        this.numberOfTracks = n;
    }


    /**
     * Print details about this CD to the text terminal.
     */
    public void toString()
    {
        String ret = "";
        ret = ret + "CD: " + title + " (" + playingTime + " mins)";

        if(gotIt) {
            ret = ret + "*";
        }

        ret = ret + "    " + artist;
        ret = ret + "    tracks: " + this.numberOfTracks;
        ret = ret + "    " + genre;
    }
}
