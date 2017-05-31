package media;

/**
 * The CD class represents a CD object. Information about the
 * CD is stored and can be retrieved.
 */
public class CD
{
    private String title;
    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean gotIt;
    private Genre genre;

    /**
     * Initialize the CD.
     * @param theTitle The title of the CD.
     * @param theArtist The artist of the CD.
     * @param tracks The number of tracks on the CD.
     * @param time The playing time of the CD.
     */
    public CD(String theTitle, String theArtist, int tracks, int time, Genre theGenre)
    {
        title = theTitle;
        artist = theArtist;
        numberOfTracks = tracks;
        playingTime = time;
        gotIt = false;
        genre = theGenre;
    }

    /**
     * Enter a genre for this CD.
     * @param genre The genre to be entered.
     */
    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    /**
     * @return The genre for this CD.
     */
    public Genre getGenre()
    {
        return genre;
    }

    /**
     * Set the flag indicating whether we own this CD.
     * @param ownIt true if we own the CD, false otherwise.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * @return true if we own a copy of this CD.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Print details about this CD to the text terminal.
     */
    public void print()
    {
        System.out.print("CD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        }
	else {
            System.out.println();
        }
        System.out.println("    " + artist);
        System.out.println("    tracks: " + numberOfTracks);
        System.out.println("    " + genre);
    }
}
