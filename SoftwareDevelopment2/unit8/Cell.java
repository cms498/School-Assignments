/**
 * This program houses the Cell object, which has a type, row and column
 * It has the ability to compare two cells as well as hash them
 * 
 * Author: Chris Shepard
 */

public class Cell {
    private CellType type;
    private int row;
    private int col;

    /**
     * Basic constructor for a Cell object
     * @param type CellType enumeration
     * @param row int
     * @param col int
     */
    public Cell(CellType type, int row, int col){
        this.type = type;
        this.row = row;
        this.col = col;
    }

    /**
     * Getter method for the type of cell
     * @return CellType type
     */
    public CellType getType() {
        return type;
    }

    /**
     * Getter method for the cells row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter method for the cells col
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * This method provides the ability to compares two cells
     * they are considered equal if they have the same row and col
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Cell){
            Cell o = (Cell)other;
            return this.row == o.getRow() && this.col == o.getCol();
        }
        return false;
    }

    /**
     * This method hashes the row and col
     */
    @Override
    public int hashCode(){
        int rowVal = Integer.valueOf(this.row).hashCode();
        int colVal = Integer.valueOf(this.col).hashCode();
        return rowVal + colVal;
    }

    @Override
    public String toString(){
        return this.type + "-" + this.row + "-" + this.col;
    }
}