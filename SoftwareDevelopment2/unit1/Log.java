/**
 * This program calcultes the approximate value of the mathematical equation
 * log base b of n, where b and n are provided by the user, the result is rounded down
 * 
 * Author: Chris Shepard
 */
import java.util.Scanner;

public class Log {
    public static int log(int b, int n){
        //This method is where the calculation described above takes place
        int count = 0;
        if (n < 1){
            return -1;
        } else if (n == 1){
            return 0;
        } else{
            while (n >= b){
                n = n / b;
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        //This method calls the log method for testing output purposes, uses scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        while (b >= 1 && n >= 1){
            System.out.println(Log.log(b, n));
            System.out.print("Enter two integers: ");
            b = scanner.nextInt();
            n = scanner.nextInt();
        }
        scanner.close();
    }
}
