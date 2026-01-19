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
    
    private void handleTransactionHistory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           TRANSACTION HISTORY");
        System.out.println("=".repeat(60));
        TransactionResult result = atm.getTransactionHistory();
        System.out.println("\n" + result.getMessage());
        pressEnterToContinue();
    }
    
    private void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
