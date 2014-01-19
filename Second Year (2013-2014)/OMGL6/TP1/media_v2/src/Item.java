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
     * Empty constructor
     */
    public Item() {
        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
    }

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

        System.out.println("Titre: " + this.title + "\n Artiste: " + this.artist + "\n Temps joué: " + this.playingTime + "\n Possédé: " + this.gotIt + "\n Genre: " + this.genre);
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
}