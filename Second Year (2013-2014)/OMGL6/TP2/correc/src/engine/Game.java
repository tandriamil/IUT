package engine;

/**
 *  This class is the main class, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this adventure game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initializes all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 */

public class Game extends AbstractModel{
    private Parser parser;
    private Room currentRoom;
	private String mTextActuel;
        
    /**
     * Create the game and initialize its internal map.
     */
    public Game()  {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, entreeDonjon, salleZangdar, magasinDonjon, tunnelMagasin, taverne, salleGolem, paradis;
      
        // create the rooms
        outside = new Room("Vous �tes devant le donjon de Naheulbeuk");
        entreeDonjon = new Room("Vous etes dans l'entrée. Souvenez-vous, les aventuriers ne vont jamais tout droit");
        salleZangdar = new Room("Salle du Boss");
        magasinDonjon = new Room("Vous arrivez au magasin, vous n'avez pas d'argent, ne tuez pas la vendeuse SVP");
        tunnelMagasin = new Room("Vous avez pratiquer la ruse, et vous passez dans la trappe et vous fuyez les monstres");
        taverne = new Room("Y'a une bonne ambiance ici. Le groupe Tommy Verdatre joue au coin du feu");
        salleGolem = new Room("Le golem de fer est indestructible, l'elfe peut vous aider");
        paradis = new Room("TAGAZOK à toi mon fr�re, ici c'est le voeux de bonne santà et de bonheur");
        
        
        
        // initialise room exits
        outside.setExits("nord", entreeDonjon);
        
        entreeDonjon.setExits("nord", salleZangdar);
        entreeDonjon.setExits("est", magasinDonjon);
        entreeDonjon.setExits("sud", outside);
        
        salleZangdar.setExits("nord", salleGolem);
        salleZangdar.setExits("sud", entreeDonjon);
        salleZangdar.setExits("ouest", paradis);
        
        magasinDonjon.setExits("trappe", tunnelMagasin);
        magasinDonjon.setExits("revenir", paradis);
        
        tunnelMagasin.setExits("nord", taverne);
        tunnelMagasin.setExits("revenir", paradis);
        
        taverne.setExits("sud", tunnelMagasin);
        taverne.setExits("ouest", salleGolem);
        
        salleGolem.setExits("nord", paradis);
        salleGolem.setExits("est", taverne);
        salleGolem.setExits("sud", salleZangdar);
        salleGolem.setExits("ouest", paradis);
        
        paradis.setExits("ressusciter", outside);
        

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()  {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            mTextActuel = "";
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Et merde, on se les g�le ici. Tiens voila des gens");
        System.out.println("Nous sommes la compagnie.. euh.. nous sommes une compagnie");
        System.out.println("Si vous etes paum�, faite 'help' ");
        System.out.println();
        this.printLocationInfo();
        //AVEC LA VUE
        mTextActuel = "<html>";
        mTextActuel += "Et merde, on se les g�le ici. Tiens voila des gens<br>";
        mTextActuel += "Nous sommes la compagnie.. euh.. nous sommes une compagnie<br>";
        mTextActuel += "Si vous etes paum�, faite 'help'<br>";
        mTextActuel += "";
        this.printLocationInfo();
        
        setChanged();
        notifyObservers();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("look"))
        	printLocationInfo();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println();
        System.out.println("Voici les commandes possibles");
        System.out.println("   look go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command)  {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExits(direction);

        if (nextRoom == null) {
            System.out.println("Il n'y a rien par l�");
        }
        else {
            currentRoom = nextRoom;
            this.printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)   {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void printLocationInfo(){
        println(currentRoom.getLongDescription());
        println("");
    }
    
    private void println(String message){
    	mTextActuel += message+"<br>";
    	setChanged();
    	notifyObservers();
    }

	public String getText() {
		return mTextActuel;
	}

	@Override
	public void proceedAction(Command action) {
		this.processCommand(action);
	}
}
