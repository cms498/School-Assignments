/**
 * This program creates a pacman style maze and plays a round of pacman
 * It prompts the user for a .maz file and does full IO checking
 * 
 * Author: Chris Shepard
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeMaker {

    /**
     * This private helper function given a string creates a cell
     * @param string
     * @return a new cell
     */
    private static Cell makeCell(String string){
        String[] splitted = string.split("-");
        CellType type = null;
        if(splitted[0].equals("PE")){
            type = CellType.PELLET;
        } else if(splitted[0].equals("PP")){
            type = CellType.POWER_PELLET;
        } else if(splitted[0].equals("GH")){
            type = CellType.GHOST;
        } else {
            type = CellType.PAC_MAN;
        }
        int row = Integer.parseInt(splitted[1]);
        int col = Integer.parseInt(splitted[2]);
        return new Cell(type, row, col);
    }

    /**
     * This helper method ensures that all of the vertices are added only once to the pacmanmaze
     * it creates all of the cells and adds them to the maze
     * @param filename
     * @return a maze with all of the vertices added but not connected
     * @throws IOException
     */
    private static PacManMaze addVertices(String filename) throws IOException{
        PacManMaze pacManMaze = new PacManMaze();
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while(line != null){
            String[] splitBySpace = line.split(" ");
            Cell vertex = makeCell(splitBySpace[0]);
            pacManMaze.add(vertex);
            line = bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();
        return pacManMaze;
    }

    /**
     * This method connects all of the vertices from the addVertices function
     * if the vertices is connected to a ghost its value is set to infinity otherwise
     * it is set to a 1
     * @param filename
     * @return a pacmanmaze with all of the vertices connected
     * @throws IOException
     */
    public static PacManMaze readMaze(String filename) throws IOException{
        PacManMaze pacManMaze = addVertices(filename);
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        
        while(line != null){
            String[] splitBySpace = line.split(" ");
            Cell vertex = makeCell(splitBySpace[0]);
            for(int i = 0; i < splitBySpace.length; i++){
                Cell cellToConnect = makeCell(splitBySpace[i]);
                if(cellToConnect.getType().equals(CellType.GHOST) || vertex.getType().equals(CellType.GHOST)){
                    pacManMaze.connect(vertex, cellToConnect, Double.POSITIVE_INFINITY);
                 } else {
                    pacManMaze.connect(vertex, cellToConnect, 1);
                 }
            }
            line = bufferedReader.readLine();
        }

        fileReader.close();
        bufferedReader.close();
        return pacManMaze;
    }

    /**
     * Prompts the user to input a .maz file, this is also where the searching for the power
     * pellets occurs
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a .maz filename: ");
        String filename = scanner.nextLine();
        PacManMaze pacManMaze = readMaze(filename);
        try{
            Cell PacMan = pacManMaze.getPacMan();
            for(Cell c : pacManMaze.getPowerPellets()){
                System.out.println(pacManMaze.dijkstrasPath(PacMan, c));
                PacMan = new Cell(CellType.PAC_MAN, c.getRow(), c.getCol());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        scanner.close();
    }
}