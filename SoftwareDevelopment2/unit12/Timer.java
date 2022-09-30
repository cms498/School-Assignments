/**
 * This program uses the system time to see how long it takes to add values to certain data types
 * like a list and a vector
 * 
 * Author: Chris Shepard
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer extends Thread{
    private String name;
    private List<Integer> list;
    private int numberOfValues;
    /**
     * Basic constructor, initializes all values
     * @param name
     * @param list
     * @param numberOfValues
     */
    public Timer(String name, List<Integer> list, int numberOfValues){
        this.name = name;
        this.list = list;
        this.numberOfValues = numberOfValues;
    }

    /**
     * This method added all of the values to the data struct and prints a message when finished
     * @param name
     * @param list
     * @param numberOfValues
     */
    public static void method(String name, List<Integer> list, int numberOfValues){
        double startTime = System.nanoTime();
        for(int i = 0; i < numberOfValues; i++){
            list.add(i);
        }
        double endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Filled " + name + " with " + numberOfValues + " in " + totalTime + " nanoseconds");
    }

    /**
     * this run methods is used by the threads
     */
    @Override
    public void run(){
        method(name, list, numberOfValues);
    }

    /**
     * main method where everything is setup and ran
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();

        int numberOfValues = 100000000;
        String lString = "List";
        String vString = "Vector";


        Timer timerList = new Timer(lString, list, numberOfValues);
        Timer timerVector = new Timer(vString, vector, numberOfValues);
        Thread listThread = new Thread(timerList);
        Thread vectorThread = new Thread(timerVector);
        
        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(listThread);
        threads.add(vectorThread);

        listThread.start();
        vectorThread.start();

        for(Thread thread : threads){
            thread.join();
        }
    }
}