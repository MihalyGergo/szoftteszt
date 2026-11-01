package model;

public class BankService {
    private final NotificationService notificationService;
    private final ExchangeRateService exchangeRateService;
    public final static String depositSuccessMessage = "Deposit successful"; 
 
    public BankService(NotificationService notificationService, ExchangeRateService exchangeRateService) {
        this.notificationService = notificationService;
        this.exchangeRateService = exchangeRateService;
    }
 
    public void deposit(BankAccount account, double amount) throws IllegalArgumentException{
        account.deposit(amount);
 
        notificationService.send(depositSuccessMessage);
    }
    
    public double getBalance(BankAccount account, String curr) {
    	return account.getBalance() * exchangeRateService.getRate(account.getCurr(), curr);
    }
}
