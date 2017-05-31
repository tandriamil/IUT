package test;
import bankap.*;

public class TestSavingsAccount {
    public static void main (String [] args) {

//TestConstructeur  //Réussi
	SavingsAccount acc1 = new SavingsAccount (55, 4);
	SavingsAccount acc2 = new SavingsAccount (22, 3);

//Test autres méthodes
	//Test toString  //Réussi
	System.out.println ("Le compte de départ (compte 55) a cet état:");
	System.out.println (acc1.toString() + '\n');


	//Test deposit  //Réussi
	acc1.deposit (1500);
	System.out.println ("Le compte 55 après un dépot de 1500€:");
	System.out.println (acc1.toString() + '\n');


	//Test withdraw  //Réussi
	acc1.withdraw (500);
	System.out.println ("Le compte 55 après un retrait de 500€:");
	System.out.println (acc1.toString() + '\n');


	//Test transfer  //Réussi
	acc2.deposit (2000);
	System.out.println ("Le compte 22 au départ:");
	System.out.println (acc2.toString() + '\n');

	acc1.transfer (500, acc2);

	System.out.println ("Le compte 55 après un virement de 500€ vers le compte 22:");
	System.out.println (acc1.toString() + '\n');
	System.out.println ("Le compte 22 après un virement de 500€ depuis le compte 55:");
	System.out.println (acc2.toString() + '\n');


	//Test monthBalance + addInterest  //Réussi
	acc1.monthBalance();
	System.out.println ("Le compte 55 après l'ajout des interêts:");
	System.out.println (acc1.toString() + '\n');
    }
}
