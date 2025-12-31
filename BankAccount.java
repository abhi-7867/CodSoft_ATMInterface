import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    private List<Transaction> transactionHistory;
    private int failedPinAttempts;
    private static final int MAX_PIN_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;
    
    public BankAccount(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.transactionHistory = new ArrayList<>();
        this.failedPinAttempts = 0;
    }
    
    public boolean verifyPin(int enteredPin) {
        if (this.pin == enteredPin) {
            failedPinAttempts = 0;
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
            addTransaction("WITHDRAWAL", amount);
            return true;
        }
        return false;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        addTransaction("DEPOSIT", amount);
        return true;
    }
    
    private void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount, balance);
        transactionHistory.add(transaction);
    }
    
    public void addBalanceCheckTransaction() {
        Transaction transaction = new Transaction("BALANCE_CHECK", 0.0, balance);
        transactionHistory.add(transaction);
    }
    
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    public int getFailedPinAttempts() {
        return failedPinAttempts;
    }
    
    public void resetFailedPinAttempts() {
        failedPinAttempts = 0;
    }
}
