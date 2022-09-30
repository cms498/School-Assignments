/**
 * This program uses a path finding algorithm in combination with the alphabet
 * to spell out a word, the word will always be the shortest path
 * 
 * Author: Chris Shepard
 */

package assignment;

import graphs.WAdjacencyGraph;

public class Word {
    /**
     * main method where the creation and connections of the graph are implemented
     * @param args
     */
    public static void main(String[] args) {
        // word is PRINGLE - the chip
        WAdjacencyGraph<String> graph = new WAdjacencyGraph<>();
        graph.add("P");
        graph.add("R");
        graph.add("I");
        graph.add("N");
        graph.add("G");
        graph.add("L");
        graph.add("E");

        //establish connections to all of the letters in the word
        graph.connect("P", "R", 1);
        graph.connect("R", "I", 1);
        graph.connect("I", "N", 1);
        graph.connect("N", "G", 1);
        graph.connect("G", "L", 1);
        graph.connect("L", "E", 1);
        graph.connect("E", "P", Double.POSITIVE_INFINITY);

        //establish other connections to the other letters in the graph
        // number is arbitrary as long as it is less then the length of the
        // word in order for the alg to work properly
        graph.connect("P", "I", 10);
        graph.connect("P", "N", 10);

        graph.connect("R", "N", 10);
        graph.connect("R", "G", 10);

        graph.connect("I", "G", 10);
        graph.connect("I", "L", 10);

        graph.connect("N", "L", 10);
        graph.connect("N", "E", 10);

        graph.connect("G", "E", 10);
        graph.connect("G", "P", 10);

        graph.connect("L", "P", 10);
        graph.connect("L", "R", 10);

        graph.connect("E", "R", 10);
        graph.connect("E", "I", 10);

        // path that spells the word is found
        System.out.println(graph.dijkstrasPath("P", "E"));
    }
}