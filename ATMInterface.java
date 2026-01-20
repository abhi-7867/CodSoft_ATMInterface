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
    
    private void handleLogout() {
        System.out.println("\n" + "=".repeat(60));
        if (atm.getCurrentAccount() != null) {
            System.out.println("Thank you for using Premium ATM System!");
            System.out.println("Account: " + atm.getCurrentAccount().getAccountNumber());
            System.out.println("Logging out...");
        }
        System.out.println("=".repeat(60) + "\n");
        atm.logout();
    }
}
