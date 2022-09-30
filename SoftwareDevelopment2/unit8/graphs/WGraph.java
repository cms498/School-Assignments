package graphs;

public interface WGraph<E> {
    public abstract void add(E value);
    public abstract boolean contains(E value);
    public abstract int size();
    public abstract void connect(E a, E b, double weight);
    public abstract boolean connected(E a, E b);
    public abstract double weight(E a, E b);
    default WPath<E> dijkstrasPath(E start, E end){
        throw new UnsupportedOperationException("Function not implemented");
    }
}