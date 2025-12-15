// Basic test verification for BankAccount
public class TestAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456", 1234, 1000.0);
        assert acc.getBalance() == 1000.0;
    }
}
