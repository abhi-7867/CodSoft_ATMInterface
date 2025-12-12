public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    
    public BankAccount(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }
    
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }
}
