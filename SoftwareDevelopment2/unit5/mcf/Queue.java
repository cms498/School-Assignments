package mcf;

public interface Queue<E> {
    public abstract void enqueue(E value);
    public abstract E dequeue();
    public abstract int size();
}