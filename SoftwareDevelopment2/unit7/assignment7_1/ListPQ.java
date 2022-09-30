/**
 * This program implements a Priority queue over a linkedList
 * It provides the ability to add, remove and see the number
 * of elements inside of the queue
 * 
 * Author: Chris Shepard
 */

package assignment7_1;

import java.util.LinkedList;

public class ListPQ<Int> implements Queue<Integer>{
    private LinkedList<Integer> list;

    /**
     * Basic constructor, creates an empty linkedList
     */
    public ListPQ(){
        this.list = new LinkedList<>();
    }

    /**
     * Adds values to the end of the linkedList
     */
    @Override
    public void enqueue(Integer value) {
        this.list.add(value);
    }

    /**
     * Removes the smallest values from the linkedList
     */
    @Override
    public Integer dequeue() {
        int index = 0;
        int smallest = Integer.MAX_VALUE;
        int counter = 0;
        for(Integer node : this.list){
            if(node < smallest){
                smallest = node;
                index = counter;
            }
            counter++;
        }
        return list.remove(index);
    }

    /**
     * getter method for the number of elements in the linkedList
     */
    @Override
    public int size() {
        return this.list.size();
    }
}