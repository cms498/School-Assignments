package activities;

public class HelloThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello, World!");
    }
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            HelloThread helloThread = new HelloThread();
            helloThread.start();
            threads[i] = helloThread;
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Goodbye");
        
    }
}