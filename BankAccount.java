public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    private int failedPinAttempts;
    private static final int MAX_PIN_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;
    
    public BankAccount(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.failedPinAttempts = 0;
    }
    
    public boolean verifyPin(int enteredPin) {
        if (this.pin == enteredPin) {
            return true;
        } else {
            failedPinAttempts++;
            return false;
        }
    }
    
    public boolean isLocked() {
        return failedPinAttempts >= MAX_PIN_ATTEMPTS;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
}
