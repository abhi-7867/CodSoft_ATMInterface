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
    
    private boolean login() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("                    LOGIN");
        System.out.println("-".repeat(60));
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("\n❌ Error: Account not found. Please try again.");
            System.out.println("💡 Demo Accounts: 123456, 789012, 345678");
            return false;
        }
        
        if (account.isLocked()) {
            System.out.println("\n🔒 Account is locked due to multiple failed PIN attempts.");
            System.out.println("Please contact bank support to unlock your account.");
            return false;
        }
        
        System.out.print("Enter PIN: ");
        int pin = Integer.parseInt(scanner.nextLine().trim());
        return atm.authenticate(account, pin);
    }
}
