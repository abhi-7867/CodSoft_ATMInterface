// Terminal UI Controller for ATM System
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
    
    public void start() {
        displayWelcomeBanner();
        
        while (true) {
            if (!atm.isAuthenticated()) {
                if (!login()) {
                    continue;
                }
            }
            
            displayMainMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    handleCheckBalance();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    handleDeposit();
                    break;
                case 4:
                    handleTransactionHistory();
                    break;
                case 5:
                    handleLogout();
                    break;
                default:
                    System.out.println("\n❌ Invalid option. Please select a number between 1-5.");
            }
        }
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
        int pin = getIntInput();
        
        boolean authenticated = atm.authenticate(account, pin);
        
        if (authenticated) {
            System.out.println("\n✅ Login successful! Welcome, " + accountNumber);
        } else {
            int remainingAttempts = 3 - account.getFailedPinAttempts();
            if (remainingAttempts > 0) {
                System.out.println("\n❌ Invalid PIN. Remaining attempts: " + remainingAttempts);
            } else {
                System.out.println("\n🔒 Account locked due to multiple failed attempts.");
            }
        }
        
        return authenticated;
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
    
    private void handleWithdraw() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              WITHDRAW MONEY");
        System.out.println("=".repeat(60));
        System.out.printf("Minimum: $%.2f | Maximum: $%.2f\n", 
            ATM.getMinWithdrawal(), ATM.getMaxWithdrawal());
        System.out.print("\nEnter amount to withdraw: $");
        
        double amount = getDoubleInput();
        TransactionResult result = atm.withdraw(amount);
        
        if (result.isSuccess()) {
            System.out.println("\n✅ " + result.getMessage());
        } else {
            System.out.println("\n❌ " + result.getMessage());
        }
        
        pressEnterToContinue();
    }
    
    private void handleDeposit() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              DEPOSIT MONEY");
        System.out.println("=".repeat(60));
        System.out.printf("Minimum: $%.2f | Maximum: $%.2f\n", 
            ATM.getMinDeposit(), ATM.getMaxDeposit());
        System.out.print("\nEnter amount to deposit: $");
        
        double amount = getDoubleInput();
        TransactionResult result = atm.deposit(amount);
        
        if (result.isSuccess()) {
            System.out.println("\n✅ " + result.getMessage());
        } else {
            System.out.println("\n❌ " + result.getMessage());
        }
        
        pressEnterToContinue();
    }
    
    private void handleTransactionHistory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           TRANSACTION HISTORY");
        System.out.println("=".repeat(60));
        
        TransactionResult result = atm.getTransactionHistory();
        System.out.println("\n" + result.getMessage());
        
        pressEnterToContinue();
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
    
    private int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
    
    private double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.print("Amount cannot be negative. Please enter a valid amount: $");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid amount: $");
            }
        }
    }
    
    private void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        ATMInterface atmInterface = new ATMInterface();
        atmInterface.start();
    }
}
