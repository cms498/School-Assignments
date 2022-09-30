package mcf;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.elements = new Object[2];
        this.size = 0;
    }

    @Override
    public void append(E Value) {
        if(size == elements.length){
            Object[] copy = Arrays.copyOf(elements, size * 2);
            this.elements = copy;
        }
        elements[size] = Value;
        size ++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException(index);
        }
        
        E value = (E)elements[index];
        return value;
    }

    @Override
    public void set(int index, E Value) {
        elements[index] = Value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, size);
    }
}