/**
 * This program is where the movemaker class is, used in the gui, another part in the MVC
 */

package memory.memory.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveMaker implements EventHandler<ActionEvent>{
    private int col;
    private int row;
    private MemoryGUI memoryGUI;

    public MoveMaker(int col, int row, MemoryGUI memoryGUI){
        this.col = col;
        this.row = row;
        this.memoryGUI = memoryGUI;
    }

    @Override
    public void handle(ActionEvent arg0) {
        memoryGUI.makeMove(this.col, this.row);
    }
}
