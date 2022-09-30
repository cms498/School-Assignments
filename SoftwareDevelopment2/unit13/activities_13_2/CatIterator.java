package activities_13_2;

import java.util.Iterator;
import java.util.List;

public class CatIterator<E> implements Iterator<E> {

    private List<E> values;
    private int index;

    public CatIterator(List<E> values){
        this.values = values;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.values.size();
    }

    @Override
    public E next() {
        E value = values.get(index);
        index++;
        return value;
    }
}