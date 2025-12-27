import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }
    
    public String getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getBalanceAfter() {
        return balanceAfter;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
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
