package activities;

public class TheCount extends Thread {
    private static int[] COUNT = new int[1];
    private int id;

    public TheCount(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("The Count # = " + this.id + " is starting ...");
        for(int i = 0; i < 100000; i++){
            synchronized(COUNT){
                COUNT[0] = COUNT[0] + 1;
            }
        }
        System.out.println("The Count # = " + this.id + " has finished");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 1; i < 11; i++){
            TheCount count = new TheCount(i);
            count.start();
            threads[i - 1] = count;
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println(COUNT[0]);
    }
}