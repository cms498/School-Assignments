/**
 * This program prints out the numbers from 1 to 100 using the wait and notifying all keyword
 * 
 * Author: Chris Shepard
 */

public class EvensAndOdds {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object(); // the object which both threads share

        /**
         * This thread prints out the odd numbers
         */
        Thread odds = new Thread(){
            public void run(){
                synchronized(lock){
                    for(int i = 1; i <= 99; i++){
                        if(i == 1){
                            System.out.println(i);
                            lock.notifyAll();
                            continue;
                        }
                        if(i % 2 != 0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // squash
                            }
                            System.out.println(i);
                            lock.notifyAll();
                        }
                    }
                }
            }
        };

        /**
         * This thread prints out the even numbers
         */
        Thread evens = new Thread(){
            public void run(){
                synchronized(lock){
                    for(int i = 2; i < 101; i++){
                        if(i % 2 == 0){
                            System.out.println(i);
                            lock.notifyAll();
                            if(i == 100){
                                break;
                            }
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // squash
                            }
                        }
                    }
                }
            }
        };
        //both threads are started
        odds.start();
        evens.start();
    }
}