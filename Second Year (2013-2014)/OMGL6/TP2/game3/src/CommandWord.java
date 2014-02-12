/**
 * Enum class for the list of command words
 */
public enum CommandWord {
	//Directly created
	look("look"), go("go"), help("help"), quit("quit"), unknown("unknown");

	private String commande = "";

	/**
	 * Constructor
	 */
	CommandWord(String commande) {
		this.commande = commande;
	}


	/**
	 * Method to get the command
	 * @return The String of the command
	 */
	public String getCommand() {
		return this.commande;
	}

}