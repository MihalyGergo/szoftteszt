package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BankAccountTests {
	BankAccount account;
	@BeforeEach
	void initAccount() {
		account = new BankAccount();
	}
	
	<T extends Throwable> T assertThrowsWithoutChange(Class<T> exception, Executable executable) {
		double balanceBefore = account.getBalance();
		T ex = assertThrows(exception, executable);
		assertEquals(balanceBefore, account.getBalance());
		return ex;
	}
	
	@Test
	void balanceIsInitZero() {
		assertEquals(0, account.getBalance());
	}
	
	@Test
	void deposit_SimpleDeposit() {
		double amount = 1000; 
		account.deposit(amount);
		assertEquals(amount, account.getBalance());
	}
	
	@Test
	void deposit_MultipleDeposits() {
		double amount1 = 1000;
		double amount2 = 234;
		double amount3 = 8123;
		account.deposit(amount1);
		account.deposit(amount2);
		account.deposit(amount3);
		assertEquals(amount1 + amount2 + amount3, account.getBalance());
	}
	
	@Test
	void deposit_DepositNegative() {
		double amount = 497;
		account.deposit(amount);
		assertThrowsWithoutChange(IllegalArgumentException.class, () -> account.deposit(-1));
	}
	
	@Test
	void deposit_DepositZero() {
		double amount = 8743948;
		account.deposit(amount);
		assertThrowsWithoutChange(IllegalArgumentException.class, () -> account.deposit(0));
	}
	
	@Test
	void withdraw_SimpleWithdraw() {
		double deposit = 1000;
		double withdraw = 123;
		account.deposit(deposit);
		account.withdraw(withdraw);
		assertEquals(deposit - withdraw, account.getBalance());
	}
	
	@Test
	void withdraw_WithdrawAll() {
		double amount = 87139;
		account.deposit(amount);
		account.withdraw(amount);
		assertEquals(0, account.getBalance());
	}
	
	@Test
	void withdraw_WithdrawMoreThenBalance() {
		double amount = 9573;
		account.deposit(amount);
		assertThrowsWithoutChange(IllegalArgumentException.class, () -> account.withdraw(amount + 726));
	}
	
	@Test
	void withdraw_WithdrawNegative() {
		double amount = 8274;
		account.deposit(amount);
		assertThrowsWithoutChange(IllegalArgumentException.class, () -> account.withdraw(-1));
	}
	
	@Test
	void withdraw_WithdrawZero() {
		double amount = 51623;
		account.deposit(amount);
		assertThrowsWithoutChange(IllegalArgumentException.class, () -> account.withdraw(0));
	}
	
	
	
}
