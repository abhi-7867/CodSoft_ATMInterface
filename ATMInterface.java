import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMInterface {
    private ATM atm;
    private Map<String, BankAccount> accounts;
    private Scanner scanner;
    
    public ATMInterface() {
        this.atm = new ATM();
        this.accounts = new HashMap<>();
        this.scanner = new Scanner(System.in);
        initializeSampleAccounts();
    }
    
    private void initializeSampleAccounts() {
        accounts.put("123456", new BankAccount("123456", 1234, 5000.0));
        accounts.put("789012", new BankAccount("789012", 5678, 2500.0));
        accounts.put("345678", new BankAccount("345678", 9012, 10000.0));
    }
    
    private void handleWithdraw() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              WITHDRAW MONEY");
        System.out.println("=".repeat(60));
        System.out.printf("Minimum: $%.2f | Maximum: $%.2f\n", 
            ATM.getMinWithdrawal(), ATM.getMaxWithdrawal());
        System.out.print("\nEnter amount to withdraw: $");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        TransactionResult result = atm.withdraw(amount);
        if (result.isSuccess()) {
            System.out.println("\n✅ " + result.getMessage());
        } else {
            System.out.println("\n❌ " + result.getMessage());
        }
        pressEnterToContinue();
    }
    
    private void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
