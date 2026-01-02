public class ATM {
    private BankAccount currentAccount;
    
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
