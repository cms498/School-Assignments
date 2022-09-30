/**
 * This program houses a main method where all of the movie stars and their films
 * are connected to eachother by hand, shows how most actors are connected in more
 * ways then one
 * 
 * Author: Chris Shepard
 */

import graphs.AdjacencyGraph;

public class SixDegrees {
    public static void main(String[] args) {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();

        graph.add("Jurassic World"); // movie 1

        graph.add("Chris Pratt"); //jurassic world actor 1
        graph.add("Bryce Dallas Howard"); //jurassic world actor 2
        graph.add("Iffran Khan"); //jurassic world actor 3

        graph.connectUndirected("Jurassic World", "Chris Pratt");
        graph.connectUndirected("Jurassic World", "Bryce Dallas Howard");
        graph.connectUndirected("Jurassic World", "Iffran Khan");

        graph.add("Guardians of the Galaxy"); // movie 2
        graph.connectUndirected("Guardians of the Galaxy", "Chris Pratt");

        graph.add("Vin Diesel"); // actor 1
        graph.add("Bradley Cooper"); // actor 2
        graph.add("Zoe Saldana"); // actor 3

        graph.connectUndirected("Guardians of the Galaxy", "Vin Diesel");
        graph.connectUndirected("Guardians of the Galaxy", "Bradley Cooper");
        graph.connectUndirected("Guardians of the Galaxy", "Zoe Saldana");

        graph.add("The Hangover Part III"); // movie 3
        graph.connectUndirected("The Hangover Part III", "Bradley Cooper");

        graph.add("Ed Helms"); // actor 1
        graph.add("John Goodman"); // actor 2
        graph.add("Jeffrey Tambor"); // actor 3

        graph.connectUndirected("The Hangover Part III", "Ed Helms");
        graph.connectUndirected("The Hangover Part III", "John Goodman");
        graph.connectUndirected("The Hangover Part III", "Jeffrey Tambor");

        graph.add("Monsters Inc"); // movie 4
        graph.connectUndirected("Monsters Inc", "John Goodman");

        graph.add("Billy Crystal"); // actor 1
        graph.add("Steve Buscemi"); // actor 2
        graph.add("Jennifer Tilly"); // actor 3

        graph.connectUndirected("Monsters Inc", "Billy Crystal");
        graph.connectUndirected("Monsters Inc", "Steve Buscemi");
        graph.connectUndirected("Monsters Inc", "Jennifer Tilly");

        /**
         * Where the BFpath is found after created the connections
         */
        System.out.println(graph.bfPath("Chris Pratt", "Steve Buscemi"));
        System.out.println(graph.bfPath("Chris Pratt", "The Hangover Part III"));

        System.out.println(graph.bfPath("Jennifer Tilly", "Vin Diesel"));
        System.out.println(graph.bfPath("Jennifer Tilly", "Iffran Khan"));
        
    }
}