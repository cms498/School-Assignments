/**
 * This program creates the Chez Woolie restaurant functionality, people can leave and enter the 
 * store, a menu of items it also created and can be changed
 * the main loop creates all of the other components and runs the simulation
 * 
 * Author: Chris Shepard
 */

package assignment_11_2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChezWoolie {
    public static final int WOOLECONDS = 100; // can be changed to any value to change speed of progra,
    private int dinerCount;
    private LinkedList<Food> conveyor; // the thing the made food is placed on
    public static final ArrayList<Food> options; // the menu to pick from for the chefs

    /**
     * Basic constructor, sets the diner count to zero and the converyor to empty
     */
    public ChezWoolie(){
        this.dinerCount = 0;
        this.conveyor = new LinkedList<Food>();
    }

    /**
     *  at compile this will create a new menu for the chefs and fill it with options
     */
    static{
        options = new ArrayList<>();
        options.add(new Food("Pepperoni Pizza", 2));
        options.add(new Food("French Fries", 2));
        options.add(new Food("Strawberry Shortcake", 2));
        options.add(new Food("Banana Split", 4));
        options.add(new Food("Turkey Leg", 3));
    }

    /**
     * called when a diner enters the restaurant
     */
    public synchronized void enter(){
        dinerCount++;
    }

    /**
     * cakked when a diner leaves the restaurtant
     */
    public synchronized void exit(){
        dinerCount--;
    }

    /**
     * getter method for the conveyor of food
     * @return conveyor
     */
    public LinkedList<Food> getConveyor() {
        return conveyor;
    }

    /**
     * getter method for the diner count
     * @return diner count
     */
    public int getDinerCount() {
        return dinerCount;
    }

    /**
     * main loop where the sim is run
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Chez Woolie is opening for the day!");
        ChezWoolie restaurant = new ChezWoolie(); 
        Thread chef1 = new Thread(new Chefs(restaurant, "Chef 1"));
        Thread chef2 = new Thread(new Chefs(restaurant, "Chef 2"));
        chef1.start();
        chef2.start();
        for(int i = 0; i < 10; i++){
            new Thread(new Diner("Diner "+ (i + 1), restaurant)).start();
        }
        chef1.join();
        chef2.join();
        System.out.println("Chez Woolie is closing for the night!");
    }
}