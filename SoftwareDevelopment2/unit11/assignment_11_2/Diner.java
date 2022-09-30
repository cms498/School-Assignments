/**
 * This program represents the diner object, it can take items off the conveyor belt, they
 * will leave the restaurant once they are full
 * 
 * Author: Chris Shepard
 */

package assignment_11_2;

import java.util.List;
import java.util.Random;

public class Diner implements Runnable{
    private Random RNG = new Random();
    private String name;
    private int hungerRating;
    private ChezWoolie restaurant;

    /**
     * Basic constructor, it initilizes all value and sets the huner to a random number [5, 10]
     * @param name
     * @param restaurant
     */
    public Diner(String name, ChezWoolie restaurant){
        this.name = name;
        this.restaurant = restaurant;
        this.hungerRating = RNG.nextInt(6) + 5;
    }

    @Override
    public void run(){
        restaurant.enter();
        System.out.println(this.name + " enters the restaurant!");
        List<Food> conveyor = restaurant.getConveyor();
        Food food = null;
        System.out.println(this.name + " wants " + this.hungerRating + " servings of food");
        
        while(this.hungerRating > 0){ // if the customer is still hungru
            while(food == null){
                synchronized(conveyor){
                    if(conveyor.size() > 0){
                        food = conveyor.remove(0); // remove an item from the conveyor
                    } else {
                        try {
                            conveyor.wait(); // if the conveyor is empty wait
                        } catch (InterruptedException e) {
                            //squash
                        }
                    }
                    if(food != null){
                        System.out.println(this.name + " begins to eat " + food);
                    }
                }
            }
            try {
                Thread.sleep(ChezWoolie.WOOLECONDS * food.getServings()); // sleep for time so it aligns
            } catch (InterruptedException e) {
                // squash
            }
            this.hungerRating -= food.getServings(); //eat the food
            if(this.hungerRating > 0){ // check out hunger rating
                System.out.println(this.name + " finishes eating " + food.toString() + " and it still hungry");
                food = null;
            }
        }

        System.out.println(this.name + " finishes eating " + food + " and is full.");
        restaurant.exit(); //leave the restaurant once full
        System.out.println(this.name + " exits the restaurant.");
    }

    /**
     * getter method for the diner name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for the diner huner rating
     * @return hunger rating
     */
    public int getHungerRating() {
        return hungerRating;
    }
}