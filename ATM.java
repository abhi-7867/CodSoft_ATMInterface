/**
 * ATM class represents an ATM machine
 * Handles all ATM operations: withdrawal, deposit, balance check
 * Validates transactions and manages interactions with bank accounts
 */
public class ATM {
    private BankAccount currentAccount;
    private static final double MIN_WITHDRAWAL = 10.0;
    private static final double MAX_WITHDRAWAL = 5000.0;
    private static final double MIN_DEPOSIT = 5.0;
    private static final double MAX_DEPOSIT = 10000.0;
    
    /**
     * Verify user PIN and set current account
     * @param account The bank account
     * @param pin The PIN to verify
     * @return true if PIN is correct, false otherwise
     */
    public boolean authenticate(BankAccount account, int pin) {
        if (account == null) {
            return false;
        }
        
        if (account.isLocked()) {
            return false;
        }
        
        boolean isValid = account.verifyPin(pin);
        if (isValid) {
            this.currentAccount = account;
        }
        return isValid;
    }
    
    /**
     * Logout from the current account
     */
    public void logout() {
        currentAccount = null;
    }
    
    /**
     * Check if user is authenticated
     * @return true if authenticated, false otherwise
     */
    public boolean isAuthenticated() {
        return currentAccount != null;
    }
    
    /**
     * Withdraw money from the current account
     * @param amount The amount to withdraw
     * @return TransactionResult object containing success status and message
     */
    public TransactionResult withdraw(double amount) {
        if (!isAuthenticated()) {
            return new TransactionResult(false, "Error: No account is currently authenticated.");
        }
        
        if (amount < MIN_WITHDRAWAL) {
            return new TransactionResult(false, 
                String.format("Error: Minimum withdrawal amount is $%.2f", MIN_WITHDRAWAL));
        }
        
        if (amount > MAX_WITHDRAWAL) {
            return new TransactionResult(false, 
                String.format("Error: Maximum withdrawal amount is $%.2f", MAX_WITHDRAWAL));
        }
        
        if (currentAccount.getBalance() < amount) {
            return new TransactionResult(false, 
                String.format("Error: Insufficient balance. Current balance: $%.2f", 
                    currentAccount.getBalance()));
        }
        
        boolean success = currentAccount.withdraw(amount);
        if (success) {
            return new TransactionResult(true, 
                String.format("Successfully withdrew $%.2f. New balance: $%.2f", 
                    amount, currentAccount.getBalance()));
        } else {
            return new TransactionResult(false, "Error: Withdrawal failed.");
        }
    }
    
    /**
     * Deposit money into the current account
     * @param amount The amount to deposit
     * @return TransactionResult object containing success status and message
     */
    public TransactionResult deposit(double amount) {
        if (!isAuthenticated()) {
            return new TransactionResult(false, "Error: No account is currently authenticated.");
        }
        
        if (amount < MIN_DEPOSIT) {
            return new TransactionResult(false, 
                String.format("Error: Minimum deposit amount is $%.2f", MIN_DEPOSIT));
        }
        
        if (amount > MAX_DEPOSIT) {
            return new TransactionResult(false, 
                String.format("Error: Maximum deposit amount is $%.2f", MAX_DEPOSIT));
        }
        
        boolean success = currentAccount.deposit(amount);
        if (success) {
            return new TransactionResult(true, 
                String.format("Successfully deposited $%.2f. New balance: $%.2f", 
                    amount, currentAccount.getBalance()));
        } else {
            return new TransactionResult(false, "Error: Deposit failed.");
        }
    }
    
    /**
     * Check the balance of the current account
     * @return TransactionResult object containing success status and balance information
     */
    public TransactionResult checkBalance() {
        if (!isAuthenticated()) {
            return new TransactionResult(false, "Error: No account is currently authenticated.");
        }
        
        double balance = currentAccount.getBalance();
        currentAccount.addBalanceCheckTransaction();
        return new TransactionResult(true, 
            String.format("Current balance: $%.2f", balance));
    }
    
    /**
     * Get transaction history for the current account
     * @return TransactionResult object containing success status and transaction history
     */
    public TransactionResult getTransactionHistory() {
        if (!isAuthenticated()) {
            return new TransactionResult(false, "Error: No account is currently authenticated.");
        }
        
        var history = currentAccount.getTransactionHistory();
        if (history.isEmpty()) {
            return new TransactionResult(true, "No transaction history available.");
        }
        
        StringBuilder historyText = new StringBuilder("Transaction History:\n");
        historyText.append("=".repeat(60)).append("\n");
        for (Transaction transaction : history) {
            historyText.append(transaction.toString()).append("\n");
        }
        historyText.append("=".repeat(60));
        
        return new TransactionResult(true, historyText.toString());
    }
    
    /**
     * Get the current account
     * @return The current BankAccount object
     */
    public BankAccount getCurrentAccount() {
        return currentAccount;
    }
    
    /**
     * Get minimum withdrawal amount
     * @return Minimum withdrawal amount
     */
    public static double getMinWithdrawal() {
        return MIN_WITHDRAWAL;
    }
    
    /**
     * Get maximum withdrawal amount
     * @return Maximum withdrawal amount
     */
    public static double getMaxWithdrawal() {
        return MAX_WITHDRAWAL;
    }
    
    /**
     * Get minimum deposit amount
     * @return Minimum deposit amount
     */
    public static double getMinDeposit() {
        return MIN_DEPOSIT;
    }
    
    /**
     * Get maximum deposit amount
     * @return Maximum deposit amount
     */
    public static double getMaxDeposit() {
        return MAX_DEPOSIT;
    }
}

/**
 * TransactionResult class to encapsulate transaction results
 * Contains success status and message
 */
class TransactionResult {
    private boolean success;
    private String message;
    
    public TransactionResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public String getMessage() {
        return message;
    }
}

