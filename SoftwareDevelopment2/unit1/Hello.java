import java.util.Scanner;

public class Hello {
    public static void helloYou() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Hello, " + name);
        scanner.close();
    }
    public static void main(String[] args) {
        helloYou();
    }
}
