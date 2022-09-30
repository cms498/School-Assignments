/**
 * This program houses the stack interface which is an abstract data type
 * 
 * Author: Chris Shepard
 */

package assignment6_1;

public interface Stack<E> extends Iterable<E>{
    public abstract int size(); // returns the number of elements in the stack
    public abstract E top(); // returns the top value in the stack
    public abstract void push(E value); // adds a value to the stack
    public abstract E pop(); // removes the top value of the stack
}