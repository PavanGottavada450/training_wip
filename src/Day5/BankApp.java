package Day5;

interface Bank {
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
	
	default void displayAccountType() {
		System.out.println("Generic Bank Account");
	}
	
	default void executeTransaction(String type, double amount) {
		if(!Bank.isValid(amount)) {
			System.out.println("Invalid : " + amount);
			return;
		}
		
		switch (type.toUpperCase()) {
			case "DEPOSIT":
				deposit(amount);
				System.out.println("Deposited $" + amount + ". New balance : $" + getBalance());
				break;
			case "WITHDRAW":
				withdraw(amount);
				System.out.println("Withdraw $" + amount + ".New balance : $" + getBalance());
				break;
			default:
				System.out.println("Unknown transaction type : " + type);
		}
		
	}
	
	static boolean isValid(double amount) {
		return amount > 0;
	}
	
}


class SavingsAccount implements Bank{
	private double balance;
	
	public SavingsAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	@Override
	public double getBalance() {
	    return balance;
	}
	
	@Override
	public void deposit(double amount) {
		balance += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("Insufficient funds to withdraw $" + amount);
		}
	}
	
	@Override
	public void displayAccountType() {
		System.out.println("Account Type : Saving Account");
	}
	
	
}


public class BankApp {

	public static void main(String[] args) {

		Bank account = new SavingsAccount(1000);
		
		account.displayAccountType();          
        account.executeTransaction("deposit", 500);   
        account.executeTransaction("withdraw", 200); 
        account.executeTransaction("withdraw", -50);  // invalid
        System.out.println("Final Balance: $" + account.getBalance());

	}

}
