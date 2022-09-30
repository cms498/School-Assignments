package activities;

public class Waiter implements Runnable {
    private Object lock;

    public Waiter(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            try {
                //lock.notify();
                System.out.println("About to wait ...");
                lock.wait();
                System.out.println("This is a message after the lock wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for(int i = 0; i < 10; i++){
            Waiter waiter = new Waiter(lock);
            Thread thread = new Thread(waiter);
            thread.start();
        }
        Thread.sleep(1000);
        synchronized(lock){
            System.out.println("About to Notify");
            lock.notifyAll();
            System.out.println("Notified");
        }
    }
}