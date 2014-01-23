package media;

import java.util.ArrayList;

/**
 * The database class provides a facility to store CD and video 
 * objects. A list of all CDs and videos can be printed to the
 * terminal.
 * 
 */
public class Database
{
    private ArrayList<Item> medias;

    /**
     * Construct an empty Database.
     */
    public Database()
    {
        this.medias = new ArrayList<Item>();
    }

    /**
     * Add an Item to the database.
     * @param theItem The Item to be added.
     */
    public void addItem(Item theItem)
    {
        this.medias.add(theItem);
    }

    /**
     * Print a list of all currently stored CDs and DVDs to the
     * text terminal.
     */
    public void list()
    {
        while (this.medias.iterator().hasNext()) {
            Item it = this.medias.iterator().next();
            System.out.println(it.toString());
        }
    }
}