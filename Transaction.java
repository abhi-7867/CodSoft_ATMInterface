import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Transaction class represents a single transaction record
 * Stores transaction type, amount, balance after transaction, and timestamp
 */
public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Constructor to create a new transaction
     * @param type The type of transaction (WITHDRAWAL, DEPOSIT, BALANCE_CHECK)
     * @param amount The amount involved in the transaction
     * @param balanceAfter The balance after the transaction
     */
    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }
    
    /**
     * Get the transaction type
     * @return The transaction type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Get the transaction amount
     * @return The amount
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     * Get the balance after the transaction
     * @return The balance after
     */
    public double getBalanceAfter() {
        return balanceAfter;
    }
    
    /**
     * Get the transaction timestamp
     * @return The timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Get a formatted string representation of the transaction
     * @return Formatted transaction string
     */
    @Override
    public String toString() {
        String formattedTimestamp = timestamp.format(FORMATTER);
        if (type.equals("BALANCE_CHECK")) {
            return String.format("%s | %s | Balance: $%.2f", formattedTimestamp, type, balanceAfter);
        } else {
            return String.format("%s | %s | Amount: $%.2f | Balance: $%.2f", 
                formattedTimestamp, type, amount, balanceAfter);
        }
    }
}

