/**
 * This program prompts the user to enter a number, it then starts that number of threads, 
 * having them print out that number, it does this in order as well
 * 
 * Author: Chris Shepard
 */

import java.util.Scanner;

public class SequentialCount {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for(int i = 1; i <= number; i++){
            int num = i;
            Thread thread = new Thread(){
                public void run(){
                    System.out.println(num);
                }
            };
            thread.start();
            thread.join();
        }
        scanner.close();
    }
}