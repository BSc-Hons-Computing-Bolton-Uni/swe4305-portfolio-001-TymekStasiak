package Logbook.Week1;
import java.util.Scanner;

class MainTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the triangle");
        double length = scanner.nextDouble();

        System.out.print("Enter the height of the trinagle");
        double height = scanner.nextDouble();

        double perimiter = 2 * (length + height);
        double area = length * height;

        System.out.println("The perimiter of the triangle is: " + perimiter);
        System.out.println("The area of the triangle is: " + area);

    }
}

