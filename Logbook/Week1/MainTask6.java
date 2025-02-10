package Logbook.Week1;
import java.util.Scanner;
import java.time.Year;

public class MainTask6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Age: ");
        double age = scanner.nextDouble();

        int current_year = Year.now().getValue();
        double year_born = current_year - age;
        System.out.print("You were born in the year: " + year_born);
    }

}
