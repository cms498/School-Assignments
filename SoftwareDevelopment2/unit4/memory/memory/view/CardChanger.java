/**
 * This program houses the cardChanged interface, which will flip the cards over on button clicks
 * 
 * Author: Chris Shepard
 */

package memory.memory.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import memory.memory.model.Card;
import memory.memory.model.Memory;
import memory.memory.model.MemoryException;
import memory.memory.model.MemoryObserver;

public class CardChanger implements MemoryObserver{
    private final Button button;

    /**
     * Basic cardChanger construction, only takes in a button to be clicked
     * @param button
     */
    public CardChanger(Button button){
        this.button = button;
    }

    /**
     * Cardchanged from the memoryobserver interface, changes the image on the buttons
     */
    @Override
    public void cardChanged(Memory memory, int col, int row) throws MemoryException {
        Card card = memory.getCard(col, row);

        if(!card.isFaceUp()){
            button.setGraphic(new ImageView(MemoryGUI.BACK));
        } else if (card.isFaceUp()){
            if(card.getSymbol() == 'A'){
                button.setGraphic(new ImageView(MemoryGUI.A));
            }
            if(card.getSymbol() == 'B'){
                button.setGraphic(new ImageView(MemoryGUI.B));
            }
            if(card.getSymbol() == 'C'){
                button.setGraphic(new ImageView(MemoryGUI.C));
            }
            if(card.getSymbol() == 'D'){
                button.setGraphic(new ImageView(MemoryGUI.D));
            }
            if(card.getSymbol() == 'E'){
                button.setGraphic(new ImageView(MemoryGUI.E));
            }
            if(card.getSymbol() == 'F'){
                button.setGraphic(new ImageView(MemoryGUI.F));
            }
            if(card.getSymbol() == 'G'){
                button.setGraphic(new ImageView(MemoryGUI.G));
            }
            if(card.getSymbol() == 'H'){
                button.setGraphic(new ImageView(MemoryGUI.H));
            }
            if(card.getSymbol() == 'I'){
                button.setGraphic(new ImageView(MemoryGUI.I));
            }
            if(card.getSymbol() == 'J'){
                button.setGraphic(new ImageView(MemoryGUI.J));
            }
            if(card.getSymbol() == 'K'){
                button.setGraphic(new ImageView(MemoryGUI.K));
            }
        } else {
            button.setGraphic(new ImageView(MemoryGUI.BLANK));
        }
    }
}