package activities;

public class NameThread extends Thread {
    private final String string;
    private final int index;

    public NameThread(String string, int index){
        this.string = string;
        this.index = index;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(50 * index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(this.string.charAt(index));
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "Chris";
        Thread[] threads = new Thread[name.length()];
        for(int i = 0; i < name.length(); i++){
            NameThread nameThread = new NameThread(name, i);
            threads[i] = nameThread;
            nameThread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.print("!");
    }
}