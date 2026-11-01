package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BankServiceTests {
	
	
	@Mock
	NotificationService notificationService;
	
	@Mock
	ExchangeRateService exchangeRateService;
	final double eurToHufRate = 400;
	
	@InjectMocks
	BankService bankService;
	BankAccount account;
	

	
	@BeforeEach
	void initAccount() {
		account = new BankAccount();
	}
	
	@Test
	void deposit_ValidDepositSendsNotification() {
		double amount = 1000;
		bankService.deposit(account, amount);
		assertEquals(amount, account.getBalance());
		verify(notificationService, times(1)).send(BankService.depositSuccessMessage);
	}
	
	@Test
	void deposit_InvalidDepositDoesNotSendNotification() {
		double amount = 1000;
		bankService.deposit(account, amount);
		BankAccountTests.assertThrowsWithoutChange(IllegalArgumentException.class, () -> bankService.deposit(account, -10), account);
		verify(notificationService, times(1)).send(BankService.depositSuccessMessage);;
	}
	
	@Test
	void getBalance_exchangeRate() {
		double amount = 1000;
		bankService.deposit(account, amount);
		Mockito.when(exchangeRateService.getRate("HUF", "EUR")).thenReturn(1 / eurToHufRate);
		assertEquals(amount * (1 / eurToHufRate), bankService.getBalance(account, "EUR"));
	}
}
