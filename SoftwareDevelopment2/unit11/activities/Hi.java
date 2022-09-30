package activities;

import java.util.ArrayList;

public class Hi implements Runnable{
    @Override
    public void run() {
        System.out.println("Hi");
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Hi hi = new Hi();
            Thread thread = new Thread(hi);
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("Goodbye!");
    }
}