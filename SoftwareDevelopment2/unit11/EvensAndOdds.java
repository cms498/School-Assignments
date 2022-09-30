/**
 * This program uses two threads running at the same time to print the numbers from 0 to 100
 * one thread prints the odds while the other prints the evens, it does this by utilizing sleep
 * It is important to note that this doesn't work 100% of the time
 * 
 * Author: Chris Shepard
 */

public class EvensAndOdds {
    public static void main(String[] args) throws InterruptedException {
        //this threads prints out the odd numbers
        Thread odds = new Thread(){
            public void run(){
                for(int i = 1; i < 100; i++){
                    if(i % 2 != 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                    }
                }
            }
        };
        //this threads prints out the even numbers
        Thread evens = new Thread(){
            public void run(){
                for(int i = 1; i <= 100; i++){
                    if(i % 2 == 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                    }
                }
            }
        };
        //both threads are started
        odds.start();
        Thread.sleep(10);
        evens.start();
    }
}