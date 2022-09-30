package activities;

public class Deadlock implements Runnable {
    private Object lock1;
    private Object lock2;

    public Deadlock(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("trying to get into lock A ...");
            synchronized(lock1){
                System.out.println("trying to get into lock B ...");
                synchronized(lock2){
                    System.out.println("got both locked!");
                }
            }
        }
    }
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Deadlock(lock1, lock2)).start();
        new Thread(new Deadlock(lock2, lock1)).start();
    }
}