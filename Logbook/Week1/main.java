// Hello World Program
package Logbook.Week1;

import java.util.Scanner;

class Main {
    public static void main(String[] args)
    {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what's your name?");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
