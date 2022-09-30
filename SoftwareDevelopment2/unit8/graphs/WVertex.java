package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<E> {
    private E value;
    private Map<WVertex<E>, Edge<E>> edges;
    
    public WVertex(E value){
        this.value = value;
        this.edges = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    public boolean connected(WVertex<E> vertex){
        return edges.containsKey(vertex);
    }

    public void connect(WVertex<E> neighbor, double weight){
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        edges.put(neighbor, edge);
    }

    public double weight(WVertex<E> neighbor){
        Edge<E> edge = edges.get(neighbor);
        return edge.getWeight();
    }

    public Set<Edge<E>> edges(){
        return new TreeSet<Edge<E>>(edges.values());
    }

    public Edge<E> edge(WVertex<E> neighbor){
        return edges.get(neighbor);
    }

    @Override
    public String toString(){
        return this.value.toString();
    }
}