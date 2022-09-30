/**
 * This program handles incorrect input from the user in the text field, also makes guesses
 * 
 * Author: Chris Shepard
 */

package assignment5_1.view;

import assignment5_1.model.HiLo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextFieldHandler implements EventHandler<ActionEvent>{

    private TextField field;
    private HiLo hilo;

    /**
     * Basic constructor, essentially allows the game to be played
     * @param field
     * @param hilo
     */
    public TextFieldHandler(TextField field, HiLo hilo){
        this.field = field;
        this.hilo = hilo;
    } 

    /**
     * Uses regex and determines if the users input is numbers, if yes
     * those are used for the guess, if not the guess is zero
     */
    @Override
    public void handle(ActionEvent event) {
        if(!field.getText().matches("\\d+")){
            this.hilo.makeGuess(Integer.parseInt("0"));
        } else {
            this.hilo.makeGuess(Integer.parseInt(this.field.getText()));
        }
        this.field.setText("");
    }
}