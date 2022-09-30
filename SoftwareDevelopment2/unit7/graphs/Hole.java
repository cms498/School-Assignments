package graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hole{
    private final int row, col;

    public Hole(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    /**
     * Allows for basic printing of a hole object, (row, col)
     */
    @Override
    public String toString(){
        return "(" + this.row + "," + this.col + ")";
    }

    /**
     * two holes are equal if they have the same row and col num
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Hole){
            Hole other = (Hole)o;
            return other.getCol() == this.getCol() && other.getRow() == this.getRow();
        }
        return false;
    }

    /**
     * uses the value of the row and col to determine a hashcode
     */
    @Override
    public int hashCode(){
        int rowVal = Integer.valueOf(this.row).hashCode();
        int colVal = Integer.valueOf(this.col).hashCode();
        return rowVal + colVal;
    }

    /**
     * used for testing purposes, connects a small segment of the graph by hand
     * @param args
     */
    public static void main(String[] args) {
        Map<Hole, Integer> map = new HashMap<>();
        map.put(new Hole(0, 0), 0);
        map.put(new Hole(0, 3), 0);
        map.put(new Hole(5, 2), 5);
        System.out.println(map.containsKey(new Hole(5, 2))); //true
        System.out.println(map.get(new Hole(5, 2))); //5

        //Adjacency graph from 7.3 documents
        AdjacencyGraph<Hole> graph = new AdjacencyGraph<>();
        graph.add(new Hole(0, 1));
        graph.add(new Hole(0, 3));
        graph.add(new Hole(0, 5));
        graph.add(new Hole(2, 1));
        graph.add(new Hole(2, 3));
        graph.add(new Hole(2, 5));

        graph.connectUndirected(new Hole(0, 1), new Hole(2, 1));
        graph.connectUndirected(new Hole(0, 1), new Hole(2, 3));

        graph.connectUndirected(new Hole(2, 1), new Hole(0, 3));

        graph.connectUndirected(new Hole(0, 3), new Hole(0, 5));
        graph.connectUndirected(new Hole(0, 3), new Hole(2, 3));
        graph.connectUndirected(new Hole(0, 3), new Hole(2, 5));

        graph.connectUndirected(new Hole(2, 3), new Hole(0, 5));
        graph.connectUndirected(new Hole(2, 3), new Hole(2, 5));

        List<Hole> bfList = graph.bfPath(new Hole(2, 1), new Hole(0, 5));
        System.out.println("Breadth First Path = " + bfList);
        List<Hole> dfList = graph.dfPath(new Hole(2, 1), new Hole(0, 5));
        System.out.println("Depth First Path = " + dfList);
    }
}