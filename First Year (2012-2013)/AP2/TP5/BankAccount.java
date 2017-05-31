package bankap;

public abstract class BankAccount {
//Attributs
    protected int accountNumber;
    protected double balance;

//Méthodes
    //Constructeurs
    public BankAccount (int anAccountNumber) {
	this.accountNumber = anAccountNumber;
	this.balance = 0;
    }

    public BankAccount (int anAccountNumber, double initialBalance) {
	this.accountNumber = anAccountNumber;
	this.balance = initialBalance;
    }


    //Autres méthodes
    public void deposit (double amount) {
	this.balance = this.balance + amount;
    }

    public void withdraw (double amount) {
	this.balance = this.balance - amount;
    }

    public abstract double monthBalance();

    public void transfer (double amount, BankAccount other) {
	this.withdraw(amount);
	other.deposit(amount);
    }

    public String toString() {
	String ret;
	ret = "Le numéro de compte est le " + this.accountNumber + ". \n";
	ret = ret + "Le compte a un solde de " + this.balance + "€.";
	return ret;
    }
}
