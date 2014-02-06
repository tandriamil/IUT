/**
 * This class is part of the "World of Advenrture" application. 
 *
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 */

public class CommandWords {
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()   {
        // nothing to do
    }


    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)  {
        for(CommandWord cw : CommandWord.values()) {

            //If it's a valid command word
            if(cw.getCommand().equals(aString)) {
                return true;
            }
        }

        // if we get here, the string was not found in the commands
        return false;
    }


    /**
     * Method to get a command word
     * @return The CommandWord class
     */
    public CommandWord getCommandWord(String command) {
        for(CommandWord cw : CommandWord.values()){

            //If it's a valid command word
            if(cw.getCommand().equals(command)) {
                return cw;
            }

        }

        //If the command is unknow
        return CommandWord.unknown;
    }
}
