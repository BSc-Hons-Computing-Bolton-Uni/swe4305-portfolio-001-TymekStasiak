package Logbook.Week2;
import java.util.Scanner;

public class MainTask7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a mark between (0-100): ");
        int number = scanner.nextInt();

        if (number <39) {
            System.out.println("Your grade is: Fail");

        } else if (number > 39 && number < 59) {
            System.out.println("Your grade is: Pass");
        } else if (number > 59 && number < 79) {
            System.out.println("Your grade is: Merit");
        } else if (number > 79 && number <= 100) {
            System.out.println("Your grade is: Distinction");
        } else {
            System.out.println("The mark you have input is wrong, try inputting a number between 0-100");
        }
    }
}
