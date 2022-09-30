package graphs;

public class PathTuple<E> {
    private WVertex<E> vertex;
    private WVertex<E> predecessor;
    private double totalDistance;

    public PathTuple(WVertex<E> vertex){
        this.vertex = vertex;
        this.predecessor = null;
        this.totalDistance = Double.POSITIVE_INFINITY;
    }

    public WVertex<E> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return totalDistance;
    }

    public WVertex<E> getPredecessor() {
        return predecessor;
    }

    public void update(WVertex<E> predecessor, double distance){
        if(distance < this.totalDistance){
            this.totalDistance = distance;
            this.predecessor = predecessor;
        }
    }

    @Override
    public String toString(){
        return this.vertex + ":(" + this.predecessor + ", " + this.totalDistance + ")";
    }
}