/**
 * This program implemented the Stack interface in the form of a generic ArrayStack
 * 
 * Author: Chris Shepard
 */

package assignment6_1;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{
    private Object[] elements;
    private int size;

    /**
     * Basic constructor, sets elements to null and size to zero
     */
    public ArrayStack(){
        this.elements = new Object[5];
        this.size = 0;
    }

    /**
     * returns the number of elements in the stack
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * returns the top elements of the stack
     */
    @Override
    @SuppressWarnings ("unchecked")
    public E top() {
        return (E) elements[size - 1];
    }

    /**
     * adds an elements to the top of the stack
     */
    @Override
    public void push(E value) {
        elements[size] = value;
        size++;
    }

    /**
     * removes and returns the top element of stack
     */
    @Override
    @SuppressWarnings ("unchecked")
    public E pop() {
        size--;
        E value = (E)elements[size];
        elements[size] = null;
        return value;
    }

    /**
     * string representation of the stack
     */
    @Override
    public String toString(){
        String result = "[ ";
        for(int i = 0; i < elements.length; i++){
            result += elements[i] + ", ";
        }
        String formatted = result.substring(0, result.length() - 2) + " ]";
        return formatted;
    }

    /**
     * Creates an iterator for an array
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(elements, size);
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        // System.out.println("Size = " + arrayStack.size);
        // System.out.println("Top = " + arrayStack.top());
        // System.out.println("Popped = " + arrayStack.pop());
        // System.out.println("Popped = " + arrayStack.pop());
        // System.out.println("Size = " + arrayStack.size);
        // System.out.println("Top = " + arrayStack.top());
        // arrayStack.push("5");
        // System.out.println("Stack = " + arrayStack);
        for(String value : arrayStack){
            value = arrayStack.pop();
            System.out.println(value);
        }
    }
}