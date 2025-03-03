package Logbook.Week1;
import java.util.Scanner;

class HelloWorld2 {
    public static void main(String[] args)
    {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what's your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
