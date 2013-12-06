package bankap;

public class CheckingAccount extends BankAccount {
//Attributs
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;

//Méthodes
    //Constructeur
    public CheckingAccount (int accountNumber, double initialBalance) {
	super (accountNumber, initialBalance);
	transactionCount = 0;
    }

    //Autres méthodes
    public void deposit (double amount) {
	this.balance = this.balance + amount;
	transactionCount++;
    }

    public void withdraw (double amount) {
	this.balance = this.balance - amount;
	transactionCount++;
    }

    private void deducFees() {
	if (transactionCount > FREE_TRANSACTIONS) {
	    this.balance = this.balance - ((transactionCount - FREE_TRANSACTIONS) * TRANSACTION_FEE);
	}
    }

    public double monthBalance() {
	double ret;
	this.deducFees();
	ret = this.balance;
	return ret;
    }
}