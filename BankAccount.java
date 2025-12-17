public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    private static final double MIN_BALANCE = 0.0;
    
    public BankAccount(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
    }
    
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
}
