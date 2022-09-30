package graphs;

import java.util.LinkedList;
import ds.Queue;

public class TupleQueue<E> implements Queue<PathTuple<E>>{
    private LinkedList<PathTuple<E>> queue;

    public TupleQueue(){
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(PathTuple<E> element) {
        queue.add(element);
    }

    @Override
    public PathTuple<E> dequeue() {
        PathTuple<E> closest = queue.getFirst();
        int closestIndex = 0;

        for(int i = 1; i < queue.size(); i++){
            PathTuple<E> next = queue.get(i);
            if(next.getDistance() < closest.getDistance()){
                closest = next;
                closestIndex = i;
            }
        }
        queue.remove(closestIndex);
        return closest;
    }

    @Override
    public int size() {
        return queue.size();
    }
}