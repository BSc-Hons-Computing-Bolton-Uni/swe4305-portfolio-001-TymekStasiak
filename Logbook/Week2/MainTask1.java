package Logbook.Week2;
import java.util.Scanner;
import java.time.Year;

class MainTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Age: ");
        double age = scanner.nextDouble();

        int current_year = Year.now().getValue();
        int year_born = (int) (current_year - age);
        System.out.println("You were born in the year: " + year_born);
        if (age >= 18)
                System.out.println("You are over the age of 18!");
    }

}
