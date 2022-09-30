package graphs;

import java.util.HashSet;
import java.util.Set;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors;

    public Vertex(E value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public void connect(Vertex<E> neighbor){
        this.neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> vertex){
        return this.neighbors.contains(vertex);
    }

    public E getValue() {
        return value;
    }

    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}