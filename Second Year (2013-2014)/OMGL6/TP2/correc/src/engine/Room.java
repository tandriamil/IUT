package engine;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 */
public class Room {
	public String description;
	private HashMap<String, Room> exits;

	/**
	 * Create a room described "description". Initially, it has
	 * no exits. "description" is something like "a kitchen" or
	 * "an open court yard".
	 * @param description The room's description.
	 */
	public Room(String description)    {
		this.exits = new HashMap<String, Room>();
		this.description = description;
	}

	/**
	 * Define the exits of this room.  Every direction either leads
	 * to another room or is null (no exit there).
	 * @param north The north exit.
	 * @param east The east east.
	 * @param south The south exit.
	 * @param west The west exit.
	 */
	public void setExits(String direction, Room neighbor) {
		this.exits.put(direction, neighbor);
	}

	public Room getExits(String direction) {
		return exits.get(direction);
	}

	public String getExitString(){
		String sortie;
		sortie = "Sorties possibles : ";
		for (String key : exits.keySet()) {
			sortie+=key+" ";
		}
		return sortie;
	}

	public String getLongDescription() {
		return description+"<br>"+this.getExitString() ;
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}

}
