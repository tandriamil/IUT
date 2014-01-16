package test;

import media.*;

/**
 * Class for the tests
 */
public class TestDB {

	/**
	 * The main method
	 * @param args The arguments that we can insert
	 */
	public static void main(String[] args) {
		//Getting the genre values
		Genre sf = new Genre(SF);
		Genre pop = new Genre(POP);

		//Creates the DB object
		Database db = new Database();

		//Creates the objects
		DVD lotr = new DVD("Lord Of The Ring", "Peter Jackson", 240, this.sf);/*
		DVD enterTheVoid = new DVD("Lord Of The Ring", "Peter Jackson", 240, this.sf);
		DVD requiemForADream = new DVD("Lord Of The Ring", "Peter Jackson", 240, this.sf);

		CD justinBieber = new CD("Best Album Ever", "Justin Bieber", 50, this.pop);
		CD queen = new CD("Lord Of The Ring", "Peter Jackson", 240, this.sf);
		CD nightwish = new CD("Lord Of The Ring", "Peter Jackson", 240, this.sf);
		CD  = new CD("Lord Of The Ring", "Peter Jackson", 240, this.sf);*/
	}
}