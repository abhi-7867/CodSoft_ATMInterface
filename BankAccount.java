import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * BankAccount class represents a user's bank account
 * Contains account balance, account number, PIN, and transaction history
 */
public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    private List<Transaction> transactionHistory;
    private int failedPinAttempts;
    private static final int MAX_PIN_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;
    
    /**
     * Constructor to create a new bank account
     * @param accountNumber The account number
     * @param pin The PIN for the account
     * @param initialBalance The initial balance
     */
    public BankAccount(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.transactionHistory = new ArrayList<>();
        this.failedPinAttempts = 0;
    }
    
    /**
     * Verify the PIN entered by the user
     * @param enteredPin The PIN to verify
     * @return true if PIN is correct, false otherwise
     */
    public boolean verifyPin(int enteredPin) {
        if (this.pin == enteredPin) {
            failedPinAttempts = 0; // Reset failed attempts on successful login
            return true;
        } else {
            failedPinAttempts++;
            return false;
        }
    }
    
    /**
     * Check if account is locked due to too many failed PIN attempts
     * @return true if account is locked, false otherwise
     */
    public boolean isLocked() {
        return failedPinAttempts >= MAX_PIN_ATTEMPTS;
    }
    
    /**
     * Get the account balance
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Get the account number
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Withdraw money from the account
     * @param amount The amount to withdraw
     * @return true if withdrawal is successful, false otherwise
     */
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
    
    /**
     * Deposit money into the account
     * @param amount The amount to deposit
     * @return true if deposit is successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        addTransaction("DEPOSIT", amount);
        return true;
    }
    
    /**
     * Add a transaction to the transaction history
     * @param type The type of transaction (WITHDRAWAL, DEPOSIT, BALANCE_CHECK)
     * @param amount The amount involved in the transaction
     */
    private void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount, balance);
        transactionHistory.add(transaction);
    }
    
    /**
     * Add a balance check transaction (without amount)
     */
    public void addBalanceCheckTransaction() {
        Transaction transaction = new Transaction("BALANCE_CHECK", 0.0, balance);
        transactionHistory.add(transaction);
    }
    
    /**
     * Get the transaction history
     * @return List of transactions
     */
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    /**
     * Get the number of failed PIN attempts
     * @return Number of failed attempts
     */
    public int getFailedPinAttempts() {
        return failedPinAttempts;
    }
    
    /**
     * Reset failed PIN attempts (for admin purposes)
     */
    public void resetFailedPinAttempts() {
        failedPinAttempts = 0;
    }
}

