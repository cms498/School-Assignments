/**
 * This program houses the ability to update text fields on the GUI
 * 
 * Author: Chris Shepard
 */

package assignment5_1.view;

import assignment5_1.model.HiLo;
import assignment5_1.model.HiLoObserver;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIUpdater implements HiLoObserver{
    private Label hint;
    private Label guesses;
    private TextField field;

    /**
     * Basic constructor for the GUIupdater
     * @param hint
     * @param guesses
     * @param field
     */
    public GUIUpdater(Label hint, Label guesses, TextField field){
        this.hint = hint;
        this.guesses = guesses;
        this.field = field;
    }

    /**
     * Code fron the hiloObserver interface, updates the text fields accordingly
     * disables the text fields if the game ends
     */
    @Override
    public void update(HiLo game) {
        hint.setText(game.getHint());
        guesses.setText(game.getAvailableGuesses() + " guesses left");
        if(game.getAvailableGuesses() <= 0){
            guesses.setText("Game Over");
        }
        if(game.isGameOver()){
            field.setDisable(true);
        }
    }
}