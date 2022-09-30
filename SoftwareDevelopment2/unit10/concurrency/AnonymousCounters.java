package concurrency;

import java.util.Scanner;

public class AnonymousCounters{
    public static void counter(String name){
        for(int i = 1; i < 101; i++){
            System.out.println(name + " : " + i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of threads: ");
        int num = scanner.nextInt();
        for(int i = 1; i <= num; i++){
            String name = "Thread " + i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter(name);
                }
            });
            thread.start();
        }
        scanner.close();
    }
}