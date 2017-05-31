package test;
import bankap.*;

public class TestCheckingAccount {
    public static void main (String [] args) {

	//Test Constructeur  //Réussi
	CheckingAccount ca1 = new CheckingAccount (66, 2500);

	System.out.println ("L'état initial du compte 66 est:");
	System.out.println (ca1.toString() + '\n');

	//Test deposit  //Réussi
	ca1.deposit (500);
	System.out.println ("L'état du compte 66 après un dépot de 500€ :");
	System.out.println (ca1.toString() + '\n');

	//Test withdraw  //Réussi
	ca1.withdraw (1000);
	System.out.println ("L'état du compte 66 après un retrait de 1000€ :");
	System.out.println (ca1.toString() + '\n');

	//Test monthBalance sans dépassement FREE  //Réussi
	ca1.monthBalance();
	System.out.println ("L'état du compte 66 à la fin du mois si nombre de transactions gratuit non dépassé:");
	System.out.println (ca1.toString() + '\n');

	//Test monthBalance avec dépassement de 1  //Réussi
	ca1.deposit (0);
	ca1.withdraw (0);
	ca1.monthBalance();
	System.out.println ("L'état du compte 66 à la fin du mois si nombre de transactions gratuit dépassé de 1:");
	System.out.println (ca1.toString() + '\n');

	//Test monthBalance avec dépassement de 10  //Réussi
	ca1.deposit (0);
	ca1.withdraw (0);
	ca1.deposit (0);
	ca1.withdraw (0);
	ca1.deposit (0);
	ca1.withdraw (0);
	ca1.deposit (0);
	ca1.withdraw (0);
	ca1.monthBalance();
	System.out.println ("L'état du compte 66 à la fin du mois si nombre de transactions gratuit dépassé de 10:");
	System.out.println (ca1.toString() + '\n');
    }
}
