package graphs;

public class Graphs {
    public static AdjacencyGraph<String> makeGraph(){
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");
        graph.add("G");
        graph.add("H");
        graph.add("I");
        graph.add("J");
        graph.add("K");

        graph.connectDirected("J", "I");
        graph.connectUndirected("J", "K");
        graph.connectUndirected("K", "I");

        graph.connectDirected("A", "C");
        graph.connectDirected("C", "H");
        graph.connectDirected("D", "B");
        graph.connectDirected("E", "F");

        graph.connectUndirected("A", "B");
        graph.connectUndirected("B", "E");
        graph.connectUndirected("F", "G");
        graph.connectUndirected("F", "D");
        graph.connectUndirected("D", "C");
        graph.connectUndirected("C", "E");

        return graph;
    }
}