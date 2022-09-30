/**
 * On button this, this program creates a new game of memory
 * 
 * Author: Chris Shepard
 */

package memory.memory.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import memory.memory.model.Memory;
import memory.memory.model.MemoryException;

public class Restart implements EventHandler<ActionEvent>{
    private Memory memory;

    public Restart(Memory memory){
        this.memory = memory;
    }
    
    public Memory getMemory() {
        return memory;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            memory = new Memory(4, 4);
        } catch (MemoryException e) {
            e.printStackTrace();
        }
    }
}