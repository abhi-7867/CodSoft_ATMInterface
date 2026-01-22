import java.util.Scanner;

public class ATMInterface {
    private Scanner scanner = new Scanner(System.in);
    
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
}
