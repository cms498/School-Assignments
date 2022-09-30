package activities;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {
    private LinkedList<String> queue;
    private int id;
    private static final Random RNG = new Random();

    public Producer(LinkedList<String> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int number = RNG.nextInt(5) + 1;
            for(int i = 0; i < number; i++){
                String message = "Producer " + id + " : " + new Date();
                synchronized(queue){
                    queue.add(message);
                    queue.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            Consumer consumer = new Consumer(queue, i);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
        for(int i = 0; i < 2; i++){
            Producer producer = new Producer(queue, i);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }
    }
}