package activities;

public class Incrementor {
    private int count = 0;

    public void increaseCount(){
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Incrementor incrementor = new Incrementor();
        Object lock = new Object();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 100000; i++){
                        synchronized(lock){
                            incrementor.increaseCount();
                        }
                    }
                }
            });
            thread.start();
            threads[i] = thread;
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println(incrementor.getCount());
    }
}
