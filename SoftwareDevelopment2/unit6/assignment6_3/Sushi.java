/**
 * This program houses the Sushi class, it has a number, weight and price
 * it has the ability to be compared against other sushi as well as printed
 * out
 * 
 * Author: Chris Shepard
 */

package assignment6_3;

import java.util.Random;

public class Sushi implements Comparable<Sushi>{
    private int number;
    private int weight;
    private int price;
    private Random RNG;

    /**
     * Basic constructor, sets weight between 20 and 100
     * sets price between 10 and 40
     * @param number
     */
    public Sushi(int number){
        RNG = new Random();
        this.number = number;
        this.weight = RNG.nextInt(80) + 20;
        this.price = RNG.nextInt(30) + 10;
    }

    /**
     * getter method for sushis number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * getter method for sushis price
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter method for sushis weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Allows for the comparison of sushis weight
     */
    @Override
    public int compareTo(Sushi s) {
        Integer myWeight = this.weight;
        Integer otherWeight = s.getWeight();
        return myWeight.compareTo(otherWeight);
    }

    /**
     * allows for printing of a sushi object
     */
    @Override
    public String toString(){
        return "{Number = " + this.number + ", Weight = " + this.weight + " grams , $" + this.price + "}";
    }
}