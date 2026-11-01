package model;

public class BankAccount {
	private String curr = "HUF"; 
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
	
	private boolean isValidAmount(double amount) {
		return (amount > 0);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getCurr() {
		return curr;
	}
}
