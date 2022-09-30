package activities;

public class Polite implements Runnable{
    private String message;
    private static Object lock = new Object();

    public Polite(String message){
        this.message = message;
    }

    @Override
    public void run(){
        synchronized(lock){
            for(int i = 0; i < 10; i++){
                System.out.println(message);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String message = "Bruh";
        Polite polite1 = new Polite("Polite 1 = " + message);
        Polite polite2 = new Polite("Polite 2 = " + message);

        Thread t1 = new Thread(polite1);
        Thread t2 = new Thread(polite2);

        t1.start();
        t2.start();
        
    }
}