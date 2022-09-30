/**
 * This program represents a troll object, it keeps track of all the race conditions, such
 * as it is over, the positions of the racers, as well as printing messages to the GUI
 * 
 * Author: Chris Shepard
 */

package goatcarts;

import java.util.ArrayList;

public class Troll implements TrollInterface{
    private GoatCartInterface[] goatCartInterfaces;
    private Object lock;

    public Troll(){
        this.goatCartInterfaces = new GoatCartInterface[this.getNumRacers()];
        this.lock = new Object();
    }

    @Override
    public boolean getRaceFinished() {
        for(int i = 0; i < this.goatCartInterfaces.length; i++){
            if(this.goatCartInterfaces[i] == null){
                return false;
            }
            if(this.goatCartInterfaces[i].getLap() < this.getNumLaps()){
                return false;
            }
        }
        return true;
    }

    @Override
    public GoatCartInterface[] getPositions() {
        for(int i = 0; i < this.goatCartInterfaces.length; i++){
            for(int j = 0; j < this.goatCartInterfaces.length; j++){
                if(this.goatCartInterfaces[i] == null || this.goatCartInterfaces[j] == null){
                    return this.goatCartInterfaces;
                }
                if(this.goatCartInterfaces[i].getRaceTime() < this.goatCartInterfaces[j].getRaceTime()){
                    GoatCartInterface temp = this.goatCartInterfaces[i];
                    this.goatCartInterfaces[i] = this.goatCartInterfaces[j];
                    this.goatCartInterfaces[j] = temp;
                }
            }
        }
        return this.goatCartInterfaces;
    }

    @Override
    public int getNumRacers() {
        return 8;
    }

    @Override
    public int getNumLaps() {
        return 5;
    }

    public Object getLock() {
        return lock;
    }

    private int dialogueCount = 0;
    @Override
    public String getDialog() {
        String dialogue = "The racers are lining up";
        if(dialogueCount > 8 && this.getRaceFinished() == false){
            dialogue = "The racing is still going. ZOOOMMMMM!!!";
        } else if (dialogueCount != 0 && this.getRaceFinished() == true){
            dialogue = "The race has finished! PITSTOP!";
        }
        dialogueCount++;
        return dialogue;
    }

    @Override
    public void runRace() {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < this.getNumRacers(); i++){
            GoatCartInterface goat = new GoatCart(Utils.makeGoatName(), i, this);
            Thread thread = new Thread(goat);
            threads.add(thread);
            thread.start();
            goatCartInterfaces[i] = goat;
        }

        for(int i = 0; i < this.goatCartInterfaces.length; i++){
            synchronized(lock){
                try {
                    lock.wait(9000 / this.getNumRacers());
                } catch (InterruptedException e) {
                    // squash
                }
            }
        }
        synchronized(this){
            this.notifyAll();
        }
    }
}