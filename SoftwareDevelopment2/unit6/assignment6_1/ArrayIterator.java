/**
 * This program was created in class and provides the ability to iterate
 * over an array
 */

package assignment6_1;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E>{
    private Object[] elements;
    private int index;
    private int size;

    public ArrayIterator(Object[] elements, int size){
        this.elements = elements;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        E value = (E)elements[index];
        index++;
        return value;
    }
}