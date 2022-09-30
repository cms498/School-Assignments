/**
 * This program houses the order class, it uses a priorityQueue(heap)
 * on construction is calculates the cost of the order
 * 
 * Author: Chris Shepard
 */

package assignment6_3;

import java.util.PriorityQueue;

public class Order {
    private int cost;
    private PriorityQueue<Sushi> bag;
    private PriorityQueue<Sushi> bagCopy;

    /**
     * basic constructor, adds up the total for the order given a priorityQueue
     * @param bag
     */
    public Order(PriorityQueue<Sushi> bag){
        this.cost = 0;
        this.bag = bag;
        this.bagCopy = new PriorityQueue<>();
        while(this.bag.peek() != null){
            Sushi sushi = this.bag.remove();
            this.bagCopy.add(sushi);
            cost += sushi.getPrice();
        }
    }

    /**
     * getter method for the orders cost
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * getter method for the order
     * @return bag
     */
    public PriorityQueue<Sushi> getBag() {
        return bagCopy;
    }
}