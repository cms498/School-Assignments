package mcf;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    public abstract void append(E Value);
    public abstract E get(int index);
    public abstract void set(int index, E Value);
    public abstract int size();

    @Override
    default Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}