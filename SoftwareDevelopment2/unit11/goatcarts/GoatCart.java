/**
 * This program represents a goat cart object, it is runnable, and is represented by
 * a number, and name
 * 
 * Author: Chris Shepard
 */

package goatcarts;

import java.util.Random;

public class GoatCart implements GoatCartInterface{
    private String name;
    private int cartNumber;
    private int currentLap;
    private double raceTime;
    private Troll troll;
    private Object lock;

    public GoatCart(String name, int cartNumber, Troll troll){
        this.name = name;
        this.cartNumber = cartNumber;
        this.currentLap = 1;
        this.raceTime = 0.0;
        this.troll = troll;
        this.lock = new Object();
    }

    @Override
    public void run() {
        Random RNG = new Random();
        int delay = (RNG.nextInt(5) + 1) * 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // squash
        }
        synchronized(troll.getLock()){
            troll.getLock().notify();
        }
        synchronized(troll){
            try {
                troll.wait();
            } catch (InterruptedException e) {
                // squash
            }
        }
        double start = System.currentTimeMillis();
        while(this.currentLap != troll.getNumLaps()){
            for(int i = 0; i < 4; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // squash
                }
                synchronized(lock){
                    this.raceTime += System.currentTimeMillis() - start;
                }
            }
            this.currentLap ++;
        }
    }

    @Override
    public String getRacerName() {
        return this.name;
    }

    @Override
    public int getCartNumber() {
        return this.cartNumber;
    }

    @Override
    public double getRaceTime() {
        return this.raceTime;
    }

    @Override
    public int getLap() {
        return this.currentLap;
    }
}