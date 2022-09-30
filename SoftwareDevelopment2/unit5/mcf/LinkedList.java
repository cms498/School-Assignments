/**
 * This program creates a Node based implementation of an array list
 * Allows for getting and setting values, printing, and appending values
 * to the list
 * 
 * Author: Chris Shepard
 */

package mcf;

import java.util.Iterator;

public class LinkedList<E> implements List<E>{
    private Node<E> head; // node for the start head
    private Node<E> tail; // node for the end of the list
    private int size; // int for the number of elements in the list

    /**
     * Basic constructor, sets default values
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This method adds values to the end of the linkedList
     * @param Value
     */
    @Override
    public void append(E Value) {
        Node<E> node = new Node<>(Value);
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size ++;
    }

    /**
     * This method returns a value at the parameter index in
     * the Linked list
     * @param index
     */
    @Override
    public E get(int index) {
        if(index >= this.size){
            throw new IndexOutOfBoundsException(index);
        }
        int counter = 0;
        E value = this.head.getValue();
        Node<E> node = this.head.getNext();

        while(counter != index){
            if(this.head.getNext() == null){
                break;
            } else {
                value = node.getValue();
                node = node.getNext();
            }
            counter ++;
        }

        if(counter == size){
            throw new IndexOutOfBoundsException(counter);
        }

        return value;
    }

    /**
     * This method sets a value at a specified index in the linked list
     * @param index
     * @param Value
     */
    @Override
    public void set(int index, E Value) {
        if(index >= this.size){
            throw new IndexOutOfBoundsException(index);
        }

        int counter = 0;
        Node<E> node = this.head;

        while(counter < index){
            if(this.head.getNext() == null){
                break;
            } else {
                node = node.getNext();
            }
            counter++;
        }
        node.setValue(Value);
        if(counter == size){
            throw new IndexOutOfBoundsException(counter);
        }
    }

    /**
     * Returns the number of elements in the linkedList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * String representation of a linked list 
     */
    @Override
    public String toString(){
        return "Queue { " + this.head + " }";
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<>(head);
    }

    /**
     * basic main method, used for printing and visual testing, will be replaced by JUNIT testing
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("zero");
        linkedList.append("one");
        linkedList.append("two");
        linkedList.append("three");
        linkedList.append("four");
        System.out.println(linkedList);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(1));

        System.out.println(linkedList);

        linkedList.set(3, "3");
        System.out.println(linkedList);
        linkedList.set(0, "0");
        System.out.println(linkedList);
        linkedList.set(1, "1");
        System.out.println(linkedList);
    }
}