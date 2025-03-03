package Logbook.Week1;
import java.util.Scanner;

class NumberScrambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the seconds number: ");
        double number2 = scanner.nextDouble();

        System.out.println("The order in which the numbers were input is: " + number1 + " and " + number2);
        System.out.println("In the reverse order this would be: " + number2 + " and " + number1);

        scanner.close();

    }
}
