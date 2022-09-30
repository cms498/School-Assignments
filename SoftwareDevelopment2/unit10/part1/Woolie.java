/**
 * This class represents a Woolie object, it has a name, seconds to cross a bridge and a final destination
 * it provides the ability to have multiple woolies cross a bridge at the same time
 * 
 * Author: Chris Shepard
 */

package part1;

import java.util.ArrayList;

public class Woolie implements Runnable{
    private String name;
    private int seconds;
    /**
     * This enumeration represents the possible cities a Woolie can travel too
     */
    private enum Cities {
        MERCTAN,
        SICSTINE;
    }
    private Cities destination;

    /**
     * Basic constructor to create a woolie object
     * @param name the woolies name
     * @param seconds how many seconds it takes to cross the bridge
     * @param destination what city they are going too
     */
    public Woolie(String name, int seconds, Cities destination){
        this.name = name;
        this.seconds = seconds;
        this.destination = destination;
    }

    /**
     * This overrided method prints out messages depending on where the
     * woolie is on the bridge, it also sleeps the thread by a second
     */
    @Override
    public void run() {
        System.out.println(this.name + " has arrived at the bridge");
        for(int i = 0; i <= this.seconds; i++){
            if(i == 0){
                System.out.println(this.name + " is starting to cross");
            } else {
                try{
                    Thread.sleep(1000);
                    System.out.println("\t" + this.name + " " + i + " seconds");
                } catch (InterruptedException e){
                    System.out.println("Interrupted");
                }
            }
        }
        System.out.println(this.name + " arrives at " + this.destination);
    }

    /**
     * This is a main method in which all of the woolies are created
     * and their threads are started, where the printing happens
     * @param args
     */
    public static void main(String[] args) {
        Woolie woolie1 = new Woolie("Woolie 1", 4, Cities.MERCTAN);
        Woolie woolie2 = new Woolie("Woolie 2", 3, Cities.SICSTINE);
        Woolie woolie3 = new Woolie("Woolie 3", 8, Cities.SICSTINE);
        Woolie woolie4 = new Woolie("Woolie 4", 1, Cities.MERCTAN);
        ArrayList<Woolie> woolies = new ArrayList<>();
        woolies.add(woolie1);
        woolies.add(woolie2);
        woolies.add(woolie3);
        woolies.add(woolie4);
        for(Woolie woolie : woolies){
            Thread thread = new Thread(woolie);
            thread.start();
        }
    }
}