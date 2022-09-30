package concurrency;

public class CounterThread extends Thread{
    private final String name;
    public CounterThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i = 1; i < 101; i++){
            System.out.println(name + ":" + i);
        }
    }

    public static void main(String[] args) {
        CounterThread counter = new CounterThread("Thread 1");
        counter.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        for(char i = 'A'; i <= 'Z'; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}