package test;
import bankap.*;

public class AccountTest {
    public static void main (String [] args) {
	//Constructeurs
	SavingsAccount sa1 = new SavingsAccount (20, 4);
	SavingsAccount sa2 = new SavingsAccount (25, 5);

	CheckingAccount ca1 = new CheckingAccount (30, 3000);
	CheckingAccount ca2 = new CheckingAccount (35, 3500);

	//Afficheurs
	System.out.println ("Le Compte SA 20 a pour état initial:");
	System.out.println (sa1.toString() + '\n');

	System.out.println ("Le Compte CA 30 a pour état initial:");
	System.out.println (ca1.toString() + '\n');

    }
}
