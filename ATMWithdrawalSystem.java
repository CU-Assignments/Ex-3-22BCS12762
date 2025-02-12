import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final String CORRECT_PIN = "1234"; // Example PIN
    private static double balance = 1000.00; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        try {
            validatePin(enteredPin);
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            withdraw(amount);
            System.out.printf("Withdrawal successful! Remaining balance: %.2f%n", balance);
        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.printf("Your remaining balance is: %.2f%n", balance);
            scanner.close();
        }
    }

    private static void validatePin(String enteredPin) throws InvalidPinException {
        if (!enteredPin.equals(CORRECT_PIN)) {
            throw new InvalidPinException("Invalid PIN. Please try again.");
        }
    }

    private static void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
        }
        balance -= amount;
    }
}