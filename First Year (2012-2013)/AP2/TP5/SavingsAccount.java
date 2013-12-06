package bankap;

public class SavingsAccount extends BankAccount {
//Attributs
    private double interestRate; //Taux d'intérêt en % !!!

//Méthodes
    //Constructeur
    public SavingsAccount (int accountNumber, double rate) {
	super (accountNumber);
	this.interestRate = rate;
    }

    //Autres méthodes
    public double monthBalance() {
	double ret;
	this.addInterest();
	ret = this.balance;
	return ret;
    }

    public void addInterest() {
	this.balance = this.balance + (this.balance * (this.interestRate/100));
    }
}