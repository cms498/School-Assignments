/**
 * This program houses the chef object, it can add items to the conveyor belt
 * when ever the dinercount is zero the chef will wait
 * 
 * Author: Chris Shepard
 */

package assignment_11_2;

import java.util.List;
import java.util.Random;

public class Chefs implements Runnable{
    private ChezWoolie restaurant;
    private String name;

    /**
     * basic constructor, initilizes the values
     * @param restaurant
     * @param name
     */
    public Chefs(ChezWoolie restaurant, String name){
        this.restaurant = restaurant;
        this.name = name;
    }

    @Override
    public void run() {
        List<Food> conveyor = restaurant.getConveyor();
        Random RNG = new Random();
        while(restaurant.getDinerCount() == 0){ // the chef will wait until the restaurant has customers in it
            System.out.println(this.name + " is early! Waiting for customers");
            
            try {
                Thread.sleep(ChezWoolie.WOOLECONDS);
            } catch (InterruptedException e) {
                //squash
            }
        }
        while(restaurant.getDinerCount() > 0){ // it will make food, wait, then add it to the conveyor
            Food food = ChezWoolie.options.get(RNG.nextInt(ChezWoolie.options.size()));
            System.out.println(this.name + " begins to prepare " + food);

            try {
                Thread.sleep(ChezWoolie.WOOLECONDS * food.getServings());
            } catch (InterruptedException e) {
                //squash
            }
            System.out.println(this.name + " finishes " + food + " and places it on the conveyor belt");

            synchronized(conveyor){
                conveyor.add(food);
                conveyor.notifyAll();
            }
        }
    }
}