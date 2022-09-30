/**
 * This program finds the "mother" vertices given a graph, which is a vertex
 * that can reach every other point in the graph
 * 
 * Author: Chris Shepard
 */

import java.util.ArrayList;
import java.util.List;

import graphs.AdjacencyGraph;

public class Mothers {

    /**
     * This method houses the logic to find the mother vertices in a graph
     * @param graph unweighted graph of strings
     * @param values a complete list of all of the values in a graph
     * @return the list of the mother vertices inside of the graph
     */
    public static List<String> findMothers(AdjacencyGraph<String> graph, List<String> values){
        List<String> mothers = new ArrayList<>();
        boolean stillInSearch = true;

        for(int i = 0; i < values.size(); i++){
            for(int j = 0; j < values.size(); j++){
                stillInSearch = graph.bfSearch(values.get(i), values.get(j));
                if(!stillInSearch){
                    break;
                }
            }
            if(stillInSearch){
                mothers.add(values.get(i));
            }
            stillInSearch = true;
        }
        return mothers;
    }

    /**
     * main method used for testing, this is where all of the graphs are constructed and 
     * mother vertices are printed 
     * @param args
     */
    public static void main(String[] args) {
        //graph 1 and list 2
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");

        AdjacencyGraph<String> graph1 = new AdjacencyGraph<>();
        graph1.add("A");
        graph1.add("B");
        graph1.add("C");
        graph1.add("D");
        graph1.add("E");

        graph1.connectDirected("A", "B");
        graph1.connectDirected("B", "E");
        graph1.connectDirected("B", "C");
        graph1.connectDirected("E", "A");
        graph1.connectDirected("C", "D");

        System.out.println(findMothers(graph1, list1)); // should be [A B E] *any order*

        //graph 2 and list 2
        List<String> list2 = new ArrayList<>();
        list2.add("T");
        list2.add("U");
        list2.add("V");
        list2.add("W");
        list2.add("X");
        list2.add("Y");
        list2.add("Z");

        AdjacencyGraph<String> graph2 = new AdjacencyGraph<>();
        graph2.add("T");
        graph2.add("U");
        graph2.add("V");
        graph2.add("W");
        graph2.add("X");
        graph2.add("Y");
        graph2.add("Z");

        graph2.connectDirected("Z", "U");
        graph2.connectDirected("Z", "Y");
        graph2.connectDirected("Y", "W");
        graph2.connectDirected("Y", "X");
        graph2.connectDirected("X", "U");
        graph2.connectDirected("X", "T");
        graph2.connectDirected("W", "T");
        graph2.connectDirected("T", "V");

        System.out.println(findMothers(graph2, list2)); // should be [Z]

        
    }
}