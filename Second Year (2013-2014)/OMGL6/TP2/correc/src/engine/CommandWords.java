package engine;
/**
 * This class is part of the "World of Advenrture" application. 
 *
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 */

public class CommandWords {
    // a constant array that holds all valid command words

    
    //private CommandWord listCommand;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()   {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)  {
    	for(CommandWord cw : CommandWord.values()){
    		if(cw.toString().equals(aString))
    			return true;
    			
    	}
        return false;
    }
    
    public CommandWord getCommandWord(String command) {
    	for(CommandWord cw : CommandWord.values()){
    		if(cw.toString().equals(command))
    			return cw;
    			
    	}
    	return CommandWord.unknown;
	}
}
