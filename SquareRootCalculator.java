import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its square root: ");

        try {
            String input = scanner.nextLine();
            double number = Double.parseDouble(input);

            if (number < 0) {
                System.out.println("Error: Cannot calculate the square root of a negative number.");
            } else {
                double squareRoot = Math.sqrt(number);
                System.out.printf("The square root of %.2f is %.2f%n", number, squareRoot);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}