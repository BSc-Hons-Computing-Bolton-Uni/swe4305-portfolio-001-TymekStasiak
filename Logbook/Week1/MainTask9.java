package Logbook.Week1;
import java.util.Scanner;

public class MainTask9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you want to deposit into your savings account: ");
        double account = scanner.nextDouble();

        double interest = account + account / 100;
        System.out.print("The amount you will have in after next year's interest rate is: " + interest);
    }
}
