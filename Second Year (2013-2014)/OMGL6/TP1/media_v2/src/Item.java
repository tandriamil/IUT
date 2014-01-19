package media;

/**
 * The super class for all the items in the DB
 */
public abstract class Item {
	//The attributes
    protected String title;
    protected String artist;
    protected int playingTime;
    protected boolean gotIt;
    protected Genre genre;


   	/**
     * Constructor for objects of class Item
     * @param theTitle The title of this Item
     * @param theDirector The director of this Item
     * @param time The running time of the main feature
     * @param theGenre The category of this item
     */
    public Item(String theTitle, String theDirector, int time, Genre theGenre) {
        this.title = theTitle;
        this.artist = theDirector;
        this.playingTime = time;
        this.gotIt = false;
        this.genre = theGenre;
    }


    /**
     * Enter a category for this Item
     * @param genre The genre to be entered
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    /**
     * @return The genre for this Item
     */
    public Genre getGenre() {
        return genre;
    }


    /**
     * Set the flag indicating whether we own this Item
     * @param ownIt true if we own the Item, false otherwise
     */
    public void setOwn(boolean ownIt) {
        gotIt = ownIt;
    }

    /**
     * @return true if we own a copy of this Item
     */
    public boolean getOwn() {
        return gotIt;
    }


    /**
     * Print details about this Item to the text terminal
     */
    public abstract void print();
}