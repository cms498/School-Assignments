package activities;

import java.util.Random;

public class Sleeper implements Runnable{
    private int seconds;

    public Sleeper(int seconds){
        this.seconds = seconds;
    }

    @Override
    public void run() {
        System.out.println("Before Sleeping");
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            // squash
        }
        System.out.println("After Sleeping");
    }
    public static void main(String[] args) throws InterruptedException {
        Random RNG = new Random();
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            Sleeper sleeper = new Sleeper(RNG.nextInt(10000) + 1000);
            Thread thread = new Thread(sleeper);
            thread.start();
            threads[i] = thread;
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("All done");
    }
}