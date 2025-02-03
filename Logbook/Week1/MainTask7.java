package Logbook.Week1;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class MainTask7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Date of Birth (dd-MM-yyyy): ");
        String dob = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birth_date = LocalDate.parse(dob, formatter);

        LocalDate current_date = LocalDate.now();

        int days_old =
                Period.between(birth_date, current_date).getDays() +
                        Period.between(birth_date, current_date).getYears() * 365 +
                        Period.between(birth_date, current_date).getMonths() * 30;
        System.out.print("You are approximately " + days_old + " days old");
    }

}
