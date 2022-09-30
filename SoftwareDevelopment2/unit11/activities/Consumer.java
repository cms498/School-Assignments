package activities;

import java.util.LinkedList;

public class Consumer implements Runnable { 
    private LinkedList<String> queue;
    private int id;

    public Consumer(LinkedList<String> queue, int id){
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            String job = null;
            synchronized(queue){
                while(queue.size() == 0){
                    try {
                        System.out.println("Consumer " + id + " : Waiting for work ...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                job = queue.remove(0);
            }
            System.out.println(id + " : " + job);
        }
    }
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Message #1");
        queue.add("Message #2");
        Consumer consumer = new Consumer(queue, 1);
        Thread thread = new Thread(consumer);
        thread.start();
    }
}