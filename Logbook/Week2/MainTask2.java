package Logbook.Week2;
import java.util.Scanner;

public class MainTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grade (A-F) ");
        switch (scanner.next().toUpperCase()) {
            case "A" -> System.out.println("1st");
            case "B" -> System.out.println("2:1");
            case "C" -> System.out.println("2:2");
            case "D" -> System.out.println("3rd");
            case "E" -> System.out.println("Ordinary");
            case "F" -> System.out.println("Fail");
            default -> System.out.println("Invalid grade entered.");
        }
        scanner.close();
    }
}
