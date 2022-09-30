/**
 * This program represent a concentric graph, with the ability to find the center
 * generate distances between two points, as well as find the radius of the graph
 * 
 * Author: Chris Shepard
 */

package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConcentricGraph {
    private AdjacencyGraph<String> graph;
    private List<String> centers;
    
    /**
     * Basic constructor, reads in a file and creates the graph
     * only uses undirected connections
     * @param filename
     * @throws IOException
     */
    public ConcentricGraph(String filename) throws IOException {
        this.graph = new AdjacencyGraph<>();
        this.centers = new ArrayList<>();
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while(line != null){
            String[] values = line.split(", ");
            for(int i = 0; i < values.length; i++){
                if(!graph.contains(values[i])){
                    graph.add(values[i]);
                }
            }
            for(int j = 1; j < values.length; j++){
                graph.connectUndirected(values[0], values[j]);
            }
            line = reader.readLine();
        }
        reader.close();
        fileReader.close();
        searchCenters();
    }

    /**
     * Calculates the center of the graph in order to properly
     * creates the concentric circles, also filters out down
     * to the centers with the highest number of neighbors
     */
    private void searchCenters(){
        int radius = radius();
        Map<String, Vertex<String>> vertices = graph.getVertices();
        List<Vertex<String>> unfiltered = new ArrayList<>();
        List<Vertex<String>> filtered = new ArrayList<>();

        for(Vertex<String> n : vertices.values()){
            int compare = distance(n.getValue());
            if(radius == compare){
                unfiltered.add(n);
            }
        }
        int largestVertexCount = 0;
        for(Vertex<String> v : unfiltered){
            if(v.getNeighbors().size() > largestVertexCount){
                largestVertexCount = v.getNeighbors().size();
            }
        }
        for(Vertex<String> b : unfiltered){
            if(b.getNeighbors().size() == largestVertexCount){
                filtered.add(b);
            }
        }
        for(Vertex<String> v : filtered){
            centers.add(v.getValue());
        }
    }

    /**
     * Creates a distance map from a starting value, 
     * where the key is the letter and the value is the distance
     * @param start
     * @return distance map
     */
    public Map<String, Integer> distanceMap(String start){
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Vertex<String>> vertices = graph.getVertices();

        Vertex<String> startV = vertices.get(start);
        LinkedList<Vertex<String>> queue = new LinkedList<>();

        int count = 0;
        queue.add(startV);
        distances.put(start, count);

        while(queue.size() > 0){
            Vertex<String> v = queue.remove();
            count = distances.get(v.getValue()) + 1;
            for(Vertex<String> n : v.getNeighbors()){
                if(distances.containsKey(n.getValue()) == false){
                    queue.add(n);
                    distances.put(n.getValue(), count);
                }
            }
        }
        return distances;
    }

    /**
     * getter method for the centers of the concentric graph
     * @return centers list
     */
    public List<String> getCenters(){
        return this.centers;
    }
    
    /**
     * Finds and returns the max distance to any vertex start from any other point
     * @param start
     * @return largest distance
     */
    public int distance(String start){
        Map<String, Integer> distances = distanceMap(start);
        int largest = 0;
        for(Integer i : distances.values()){
            if(i > largest){
                largest = i;
            }
        }
        return largest;
    }

    /**
     * Calculates the radius of the concentric graph
     * @return largest distance from the vertex C
     */
    public int radius(){
        Map<String, Vertex<String>> vertices = graph.getVertices();
        Vertex<String> C = vertices.get(vertices.keySet().toArray()[0]);
        for(Vertex<String> v : vertices.values()){
            if(distance(C.getValue()) > distance(v.getValue())){
                C = v;
            }
        }
        return distance(C.getValue());
    }
    
    public static void main(String[] args) throws IOException{
        ConcentricGraph cGraph = new ConcentricGraph("data/connected_3.txt");
        
        System.out.println("Distance of each vertex from A:");
        System.out.println(cGraph.distanceMap("A")); 
        System.out.println("distance(A): " + cGraph.distance("A"));  
        System.out.println("Graph radius: " + cGraph.radius());
        System.out.println("Graph Centers: " + cGraph.getCenters());
        System.out.println("Concentric Graph:\n" + cGraph); // Bonus credit 
     
        System.out.println("\n");
        ConcentricGraph cGraph2 = new ConcentricGraph("data/connected_usa.txt");
        
        System.out.println("Distance of each state from New York:");
        System.out.println(cGraph2.distanceMap("New York")); 
        System.out.println("distance(New York): " + cGraph2.distance("New York"));   
        System.out.println("Graph radius: " + cGraph2.radius());
        System.out.println("Graph Centers: " + cGraph2.getCenters());
        System.out.println("Concentric Graph:\n" + cGraph2); // Bonus Credit
    }
}