package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Counters {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of runnables: ");
        int N = scanner.nextInt();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < N; i++){
            RunnableCounter rc = new RunnableCounter("Thread " + i);
            Thread thread = new Thread(rc);
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("Counter all done!");
        scanner.close();
    }
}