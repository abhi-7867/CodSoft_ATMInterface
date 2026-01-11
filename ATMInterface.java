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
    }
}
