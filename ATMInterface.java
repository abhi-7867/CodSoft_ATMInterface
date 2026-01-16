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
    
    private void displayWelcomeBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("        WELCOME TO PREMIUM ATM SYSTEM");
        System.out.println("=".repeat(60) + "\n");
    }
    
    private void displayMainMenu() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("                    MAIN MENU");
        System.out.println("-".repeat(60));
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Logout");
        System.out.println("-".repeat(60));
        System.out.print("Please select an option (1-5): ");
    }
    
    private void handleCheckBalance() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              CHECK BALANCE");
        System.out.println("=".repeat(60));
        TransactionResult result = atm.checkBalance();
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
