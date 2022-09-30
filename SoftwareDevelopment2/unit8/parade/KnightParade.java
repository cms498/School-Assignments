/**
 * This program represents the Knights Parade problem, the user is prompted to enter a 
 * board size and starting position, the algorithm then uses backtracking to solve it
 * 
 * Author: Chris Shepard
 */

package parade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import backtracker.Backtracker;
import backtracker.Configuration;

public class KnightParade implements Configuration {
    private Chessboard chessboard;
    private int row;
    private int col;

    /**
     * Basic constructor is used to make an empty knights parade
     * @param BoardDim
     * @param row
     * @param col
     */
    public KnightParade(int BoardDim, int row, int col){
        this(new Chessboard(BoardDim), row, col);
    }

    /**
     * Second constructor used to make a knights parade based using
     * a previously made chessboard
     * @param chessboard
     * @param row
     * @param col
     */
    public KnightParade(Chessboard chessboard, int row, int col){
        this.chessboard = chessboard;
        this.row = row;
        this.col = col;
    }
    
    /**
     * This method creates all of the successors for each step in the knights parade
     * It calcultes the 8 possible positions of row and col based on the current position
     * it returns a list of successors
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        int count = 0;
        while(count < 8){
            int newRow = 0;
            int newCol = 0;
            if(count == 0){
                newRow = this.row - 2;
                newCol = this.col - 1;
            } else if (count == 1){
                newRow = this.row - 2;
                newCol = this.col + 1;
            } else if (count == 2){
                newRow = this.row - 1;
                newCol = this.col + 2;
            } else if (count == 3){
                newRow = this.row + 1;
                newCol = this.col + 2;
            } else if (count == 4){
                newRow = this.row + 2;
                newCol = this.col + 1;
            } else if (count == 5){
                newRow = this.row + 2;
                newCol = this.col - 1;
            } else if (count == 6){
                newRow = this.row + 1;
                newCol = this.col - 2;
            } else {
                newRow = this.row - 1;
                newCol = this.col - 2;
            }
            Chessboard deepCopy = new Chessboard(chessboard);
            KnightParade successorConfig = new KnightParade(deepCopy, newRow, newCol);
            successors.add(successorConfig);
            count++;
            //System.out.println("Row = " + newRow + " Col = " + newCol + " \nBoard = " + successorConfig.getChessboard());
        }
        return successors;
    }

    /**
     * This method determines whether or not a given move is valid on the board or not
     * return false if so
     */
    @Override
    public boolean isValid() {
        return this.chessboard.makeMove(row, col);
    }

    /**
     * returns true is the board is full / the parade is complete
     */
    @Override
    public boolean isGoal() {
        return this.chessboard.isFull();
    }

    /**
     * getter method for the chessboard
     * @return chessboard
     */
    public Chessboard getChessboard() {
        return chessboard;
    }

    /**
     * getter method for the boards columns
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * getter method for the boards rows
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * main method where the user is prompted, the boards are created, and the 
     * algorithm takes place
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        Chessboard chessboard = new Chessboard(n);

        System.out.print("Enter a starting position: ");
        String position1 = scanner.next();
        String position2 = scanner.next();
        int row = Integer.parseInt(position1 + "");
        int col = Integer.parseInt(position2 + "");

        KnightParade config = new KnightParade(chessboard, row, col);

        chessboard.makeMove(row, col);

        Backtracker backtracker = new Backtracker(false);
        KnightParade solution = (KnightParade)backtracker.solve(config);

        if(solution != null){
            System.out.println(solution.getChessboard());
        } else {
            System.out.println("Solution not Found");
        }

        scanner.close();
    }
}