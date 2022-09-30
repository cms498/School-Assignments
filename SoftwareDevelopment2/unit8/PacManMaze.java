/**
 * This program represents a pac man maze of cells, it houses the ability
 * to add cells for the maze, as well as get the location of pacman and 
 * all of the power pellets
 * 
 * Author: Chris Shepard
 */

import java.util.ArrayList;
import java.util.List;
import graphs.WAdjacencyGraph;

public class PacManMaze extends WAdjacencyGraph<Cell>{
    private Cell pacMan;
    private List<Cell> powerPellets;

    public PacManMaze(){
        this.pacMan = null;
        powerPellets = new ArrayList<>();
    }

    /**
     * This method houses the ability to add a cell to the maze
     */
    @Override
    public void add(Cell cell){
        if(cell.getType() == CellType.PAC_MAN){
            this.pacMan = cell;
        } else if (cell.getType() == CellType.POWER_PELLET){
            powerPellets.add(cell);
        }
        super.add(cell);
    }

    /**
     * getter method for the cell housing the pacMan
     * @return pacMan
     */
    public Cell getPacMan() {
        return pacMan;
    }

    /**
     * getter method for all of the powerpellets in the graph
     * @return the list of powerPellets
     */
    public List<Cell> getPowerPellets() {
        return powerPellets;
    }
}