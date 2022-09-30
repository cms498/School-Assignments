package graphs;

import java.util.HashMap;
import java.util.Map;
//import java.util.Set;

public class WAdjacencyGraph<E> implements WGraph<E>{
    private Map<E, WVertex<E>> vertices;

    public WAdjacencyGraph(){
        this.vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        this.vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> aVertex = vertices.get(a);
        WVertex<E> bVertex = vertices.get(b);
        
        aVertex.connect(bVertex, weight);
        bVertex.connect(aVertex, weight);
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> aVertex = vertices.get(a);
        WVertex<E> bVertex = vertices.get(b);
        return aVertex.connected(bVertex);
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> aVertex = vertices.get(a);
        WVertex<E> bVertex = vertices.get(b);
        return aVertex.weight(bVertex);
    }

    @Override
public WPath<E> dijkstrasPath(E start, E end) {
    // step 1: setup
    WVertex<E> startV = vertices.get(start);
    WVertex<E> endV = vertices.get(end);

    Map<WVertex<E>, PathTuple<E>> tuples = new HashMap<>();
    TupleQueue<E> queue = new TupleQueue<>();

    for(E value : vertices.keySet()) {
        WVertex<E> vertex = vertices.get(value);
        PathTuple<E> tuple = new PathTuple<>(vertex);
        tuples.put(vertex, tuple);
        queue.enqueue(tuple);
    }

    tuples.get(startV).update(null, 0);

    // step 2: the main loop
    while(queue.size() > 0) {
        PathTuple<E> tuple = queue.dequeue();
        if(tuple.getDistance() == Double.MAX_VALUE) {
            // unreachable
            break;
        } else {
            WVertex<E> v = tuple.getVertex();
            for(Edge<E> edge : v.edges()) {
                WVertex<E> n = edge.getTo();
                double distanceToN = tuple.getDistance() + edge.getWeight();
                PathTuple<E> nTuple = tuples.get(n);
                if(distanceToN < nTuple.getDistance()) {
                    nTuple.update(v, distanceToN);
                }
            }
        }
    }

    // step 3: build the path (distance hack)
    PathTuple<E> tuple = tuples.get(endV);
    double distance = tuple.getDistance();
    if(distance < Double.MAX_VALUE) {
        WPath<E> path = new WPath<>(endV.getValue());
        WVertex<E> v = tuple.getPredecessor();
        while(v != null) {
            path.prepend(v.getValue(), distance);
            distance = 0; // hack!
            tuple = tuples.get(v);
            v = tuple.getPredecessor();
        }
        return path;
    } else {
        return null;
    }
}
}