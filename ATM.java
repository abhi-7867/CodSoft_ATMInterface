public class ATM {
    private BankAccount currentAccount;
    private static final double MIN_WITHDRAWAL = 10.0;
    private static final double MAX_WITHDRAWAL = 5000.0;
    private static final double MIN_DEPOSIT = 5.0;
    private static final double MAX_DEPOSIT = 10000.0;
    
    public boolean authenticate(BankAccount account, int pin) {
        if (account == null) {
            return false;
        }
        if (account.isLocked()) {
            return false;
        }
        boolean isValid = account.verifyPin(pin);
        if (isValid) {
            this.currentAccount = account;
        }
        return isValid;
    }
    
    public void logout() {
        currentAccount = null;
    }
    
    public boolean isAuthenticated() {
        return currentAccount != null;
    }
}
