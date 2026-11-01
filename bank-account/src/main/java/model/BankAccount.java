package model;

public class BankAccount {
	private double balance = 0;
	
	public void deposit(double amount) throws IllegalArgumentException{
		if(!isValidAmount(amount)) {
			throw new IllegalArgumentException();
		}
		balance += amount;
	}
	
	public void withdraw(double amount) throws IllegalArgumentException{
		if(!isValidAmount(amount)) {
			throw new IllegalArgumentException();
		}
		if(amount > balance) {
			throw new IllegalArgumentException();
		}
		balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	private boolean isValidAmount(double amount) {
		return (amount > 0);
	}
}
