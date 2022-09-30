package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable{
    private ArrayList<Integer> sharedList;
    private int num;
    public ListAdder(ArrayList<Integer> sharedList, int num){
        this.num = num;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++){
            sharedList.add(i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> sharedList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            ListAdder adder = new ListAdder(sharedList, 50);
            Thread thread = new Thread(adder);
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads){
            try{
                thread.join();
            } catch (InterruptedException e){
                //squash
            }
        }
        System.out.println(sharedList.size());
    }
}