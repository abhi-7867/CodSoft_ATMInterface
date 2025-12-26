import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime timestamp;
    
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
}
