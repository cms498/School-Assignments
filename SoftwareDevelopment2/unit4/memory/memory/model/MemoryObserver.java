/**
 * This interface houses the memory observer, with will help update the gui
 * 
 * Author: Chris Shepard
 */

package memory.memory.model;

public interface MemoryObserver {
    public abstract void cardChanged(Memory memory, int col, int row) throws MemoryException;
}