package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FrogHopping {
    //Uncomment
    private AdjacencyGraph<Hole> graph;
    private char[][] arrayBoard;
    private final int ROWS, COLS;

    /**
     * Basuc constructor, creates the arrayboard and empty graph, calls connect vertices to connect the vertices
     * inside of the graph, done on construction
     * @param filename
     * @throws IOException
     */
    public FrogHopping(String filename) throws IOException{
        // Initialize all of the fields
        // Construct the array and add all vertices to the graph
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        this.graph = new AdjacencyGraph<>();
        
        String line = bufferedReader.readLine();
        String[] splitted = line.split(" ");
        ROWS = Integer.parseInt(splitted[0]);
        COLS = Integer.parseInt(splitted[1]);

        this.arrayBoard = new char[ROWS][COLS];

        line = bufferedReader.readLine();
        int rowCount = 0;

        while(line != null){
            splitted = line.split(" ");
            for(int i = 0; i < splitted.length; i++){
                char[] chars = splitted[i].toCharArray();
                arrayBoard[rowCount][i] = chars[0];
            }
            rowCount++;
            line = bufferedReader.readLine();
        }

        for(int i = 0; i < arrayBoard.length; i++){
            for(int j = 0; j < arrayBoard[i].length; j++){
                if(arrayBoard[i][j] == 'H'){
                    graph.add(new Hole(i, j));
                }
            }
        }

        fileReader.close();
        bufferedReader.close();
        // Connect vertices
        connectVertices();      
    }

    /**
     * Loops over the arrayboard and connects all of the vertices together based on position
     * and neighbors
     */
    private void connectVertices(){
        for(int row = 0; row < this.arrayBoard.length; row++){
            for(int col = 0; col < this.arrayBoard[row].length; col++){
                if(this.arrayBoard[row][col] == 'P'){
                    if(row == 0 || row + 1 == ROWS){ // just the top and bottom row connections
                        if(col > 0 && this.arrayBoard[row][col - 1] == 'H' && col < COLS && this.arrayBoard[row][col + 1] == 'H'){
                            this.graph.connectUndirected(new Hole(row, col - 1), new Hole(row, col + 1));
                        }
                    }
                    if(row > 0 && col > 0 && row + 1 != ROWS && col + 1 != COLS){ // middle section of connections
                        if(this.arrayBoard[row - 1][col - 1] == 'H' && this.arrayBoard[row + 1][col + 1] == 'H'){
                            this.graph.connectUndirected(new Hole(row - 1, col - 1), new Hole(row + 1, col + 1));
                        }
                        if(this.arrayBoard[row - 1][col + 1] == 'H' && this.arrayBoard[row + 1][col - 1] == 'H'){
                            this.graph.connectUndirected(new Hole(row - 1, col + 1), new Hole(row + 1, col - 1));
                        }
                        if(this.arrayBoard[row][col - 1] == 'H' && this.arrayBoard[row][col + 1] == 'H'){
                            this.graph.connectUndirected(new Hole(row, col - 1), new Hole(row, col + 1));
                        }
                        if(this.arrayBoard[row + 1][col] == 'H' && this.arrayBoard[row - 1][col] == 'H'){
                            this.graph.connectUndirected(new Hole(row + 1, col), new Hole(row - 1, col));
                        }
                    }
                    if(col == 0 || col + 1 == COLS){ // just the left and right columns
                        if(row > 0 && this.arrayBoard[row - 1][col] == 'H' && row + 1 < ROWS && this.arrayBoard[row + 1][col] == 'H'){
                            this.graph.connectUndirected(new Hole(row - 1, col), new Hole(row + 1, col));
                        }
                    }
                }
            }
        }
    }
    
    // The frog can't jump to a hole which was visited before
    public List<Hole> dfPathV0(Hole start, Hole end) {
        return graph.dfPath(start, end);
    }

    // The frog can't jump over the same peg more than once
    public List<Hole> dfPathV1(Hole start, Hole end) {
        return null;
    }

    /**
     * Prints out all of the holes and their neighbors inside of the graph
     */
    @Override
    public String toString(){
        String string = "";
        for(Vertex<Hole> v : graph.getVertices().values()){
            string += v + ": " + v.getNeighbors() + "\n";
        }
        return string;
    }

    /**
     * Testing purposes
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FrogHopping frog = new FrogHopping("data/frog_3.txt");
        System.out.println("The frog game graph representation:");
        System.out.println(frog);
        Hole start = new Hole(2, 1);
        Hole end = new Hole(0, 5);
        System.out.println("DFPath V0 = " + frog.dfPathV0(start, end));
        //System.out.println(frog.dfPathV1(start, end)); //[(2,1), (0,3), (2,5), (2,3), (0,3), (0,5)]
    }
}