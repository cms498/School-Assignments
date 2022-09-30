package concurrency;

public class Countdown implements Runnable{
    @Override
    public void run() {
        int time = -10;
        while(true){
            if(time < 0){
                System.out.println("T-" + time);
            } else {
                System.out.println("T+" + time);
            }
            time++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
    public static void main(String[] args) {
        Thread countdown = new Thread(new Countdown());
        countdown.start();
    }
}