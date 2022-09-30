package activities_13_2;

import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");

        String name = scanner.nextLine();

        System.out.println("Hello, " + name);

        scanner.close();
    }
}