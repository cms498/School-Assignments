package graphs;

public class Edge<E> implements Comparable<Edge<E>>{
    private double weight;
    private WVertex<E> from;
    private WVertex<E> to;

    public Edge(WVertex<E> from, WVertex<E> to, double weight){
        this.weight = weight;
        this.to = to;
        this.from = from;
    }

    public double getWeight() {
        return weight;
    }

    public WVertex<E> getFrom() {
        return from;
    }

    public WVertex<E> getTo() {
        return to;
    }

    @Override
    public int compareTo(Edge<E> other) {
        double difference = this.weight - other.weight;
        if(difference > 0){
            return 1;
        } else {
            return -1;
        }
    }
}