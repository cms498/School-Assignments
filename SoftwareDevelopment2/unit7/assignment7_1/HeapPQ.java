/**
 * This program implements a priority queue using an arrayHeap
 * It provides the ability to add and remove values as well as 
 * get the number of elements in the queue
 * 
 * Author: Chris Shepard
 */

package assignment7_1;

public class HeapPQ<Int> implements Queue<Integer>{
    private ArrayHeap heap;

    /**
     * Basic constructor, creates an empty arrayHeap
     */
    public HeapPQ(){
        this.heap = new ArrayHeap();
    }

    /**
     * adds a new value to the queue at the end
     */
    @Override
    public void enqueue(Integer value) {
        this.heap.add(value);
    }

    /**
     * Removes the lowest value in the queue regardless of order
     */
    @Override
    public Integer dequeue() {
        return this.heap.remove();
    }

    /**
     * getter method for the # of elements in the queue
     */
    @Override
    public int size() {
        return this.heap.size();
    }
}