package Logbook.Week1;
import java.util.Scanner;

class MileConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of feet you want converted: ");
        double feet = scanner.nextDouble();

        double miles = feet / 5280;
        System.out.println("The converted amount equals to: " + miles + " miles");
    }
}
