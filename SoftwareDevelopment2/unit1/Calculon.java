import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculon {
    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b){
        return a / b;
    }

    public static double raise(double base, int exponent){
        double num = 1;
        for(int i = 0; i < exponent; i++){
            num *= base;
        }
        return num;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two floats: ");
        try{
        float f1 = scanner.nextFloat();
        float f2 = scanner.nextFloat();
        System.out.println(add(f1, f2));
        System.out.println(subtract(f1, f2));
        System.out.println(multiply(f1,f2));
        System.out.println(divide(f1, f2));
        } catch (InputMismatchException e){
            System.err.println("Invalid Number");
        }
        // System.out.print("Enter an int: ");
        // int i1 = scanner.nextInt();
        // System.out.println(raise(f1, i1));
        scanner.close();
    }
}
