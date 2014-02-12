import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labeled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 */
public class Room {
    public String description;

    //The hashmap for the exits
    private HashMap<String, Room> exits;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)    {
        this.description = description;
        this.exits = new HashMap<String, Room>();
    }


    /**
     * Permits to get an exit
     * @param direction The name of the exit to get
     * @return The room associated to this direction, null if nothing
     */
    public Room getExit(String direction) {
        return this.exits.get(direction);
    }


    /**
     * Permits to create an exit
     * @param direction The name of the exit
     * @param neighbor The room associated to this direction
     */
    public void setExit(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }


    /**
     * Permits to get the list of the exits
     * @return A string presentation of all the exits
     */
    public String getExitString() {
        String ret = "Exits: ";

        //Get the list of exits
        Set cles = this.exits.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
           String key = (String)it.next();
           ret = ret + key + " ";
        }

        return (ret + "\n");
    }


    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }
}
