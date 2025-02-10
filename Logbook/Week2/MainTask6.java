package Logbook.Week2;
import java.util.Scanner;

public class MainTask6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a number to see its times table (or enter '0' to exit): ");
            number = scanner.nextInt();

            if (number == 0) {
                System.out.println("Exiting program, goodbye");
                break;
            }

            System.out.println("Times table for " + number + ": ");
            for (int i = 1; i <= 12; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } while (number != 0);

        scanner.close();
    }
}
