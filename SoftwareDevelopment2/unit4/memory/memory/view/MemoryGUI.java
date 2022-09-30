/**
 * This program houses the GUI elements for the memory game
 * 
 * Author: Chris Shepard
 */

package memory.memory.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import memory.memory.model.Card;
import memory.memory.model.Memory;
import memory.memory.model.MemoryException;

public class MemoryGUI extends Application{
    static final Image BACK = new Image("file:memory/media/images/memory/back.png");
    static final Image BLANK = new Image("file:memory/media/images/memory/blank.png");
    static final Image WOOD = new Image("file:memory/media/images/memory/wood.png");
    static final Image A = new Image("file:memory/media/images/memory/goat00.png");
    static final Image B = new Image("file:memory/media/images/memory/goat01.png");
    static final Image C = new Image("file:memory/media/images/memory/goat02.png");
    static final Image D = new Image("file:memory/media/images/memory/goat03.png");
    static final Image E = new Image("file:memory/media/images/memory/goat04.png");
    static final Image F = new Image("file:memory/media/images/memory/goat05.png");
    static final Image G = new Image("file:memory/media/images/memory/troll00.png");
    static final Image H = new Image("file:memory/media/images/memory/troll01.png");
    static final Image I = new Image("file:memory/media/images/memory/troll02.png");
    static final Image J = new Image("file:memory/media/images/memory/troll03.png");
    static final Image K = new Image("file:memory/media/images/memory/troll04.png");

    private Memory memory;
    private Label description;

    /**
     * This method makes a button and puts the proper graphic on it
     * @param row
     * @param col
     * @return the card button created
     * @throws MemoryException
     */
    public Button makeCardButton(int row, int col) throws MemoryException{
        Button button = new Button("");
        button.setBackground(
            new Background(
                new BackgroundImage(
                    WOOD, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)
            )
        );
        
        Card card = memory.getCard(col, row);
        CardChanger cardChanger = new CardChanger(button);
        memory.register(cardChanger);

        if(!card.isFaceUp()){
            button.setGraphic(new ImageView(BACK));
        } else if (card.isFaceUp()){
            if(card.getSymbol() == 'A'){
                button.setGraphic(new ImageView(A));
            }
            if(card.getSymbol() == 'B'){
                button.setGraphic(new ImageView(B));
            }
            if(card.getSymbol() == 'C'){
                button.setGraphic(new ImageView(C));
            }
            if(card.getSymbol() == 'D'){
                button.setGraphic(new ImageView(D));
            }
            if(card.getSymbol() == 'E'){
                button.setGraphic(new ImageView(E));
            }
            if(card.getSymbol() == 'F'){
                button.setGraphic(new ImageView(F));
            }
            if(card.getSymbol() == 'G'){
                button.setGraphic(new ImageView(G));
            }
            if(card.getSymbol() == 'H'){
                button.setGraphic(new ImageView(H));
            }
            if(card.getSymbol() == 'I'){
                button.setGraphic(new ImageView(I));
            }
            if(card.getSymbol() == 'J'){
                button.setGraphic(new ImageView(J));
            }
            if(card.getSymbol() == 'K'){
                button.setGraphic(new ImageView(K));
            }
        } else {
            button.setGraphic(new ImageView(BLANK));
        }
        
        button.setPadding(Insets.EMPTY);
        MoveMaker moveMaker = new MoveMaker(col, row, this);
        button.setOnAction(moveMaker);
        return button;
    }

    /**
     * Makes a label on the screen
     * @param text
     * @return the created label
     */
    public Label makeLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Comic Sans MS", 48));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(20));
        return label;
    }

    /**
     * Where all of the scene elements are created and shown to the user
     */
    @Override
    public void start(Stage stage) throws Exception {
        memory = new Memory(4, 4);
        Button restart = new Button("Restart");
        Restart restart2 = new Restart(memory);
        restart.setOnAction(restart2);

        VBox side = new VBox();
        HBox hbox = new HBox();

        VBox scoreBox = new VBox();
        Label score_title = makeLabel("Score");
        Label score = makeLabel(memory.getScore() + "");
        scoreBox.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreBox.getChildren().setAll(score_title, score);

        VBox moveBox = new VBox();
        Label move_title = makeLabel("Moves");
        Label moves = makeLabel(memory.getMoves() + "");
        moveBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        moveBox.getChildren().setAll(move_title, moves);

        side.getChildren().setAll(scoreBox, moveBox);

        GridPane pane = new GridPane();
        for(int row = 0; row < memory.getRows(); row ++){
            for(int col = 0; col < memory.getCols(); col++){
                Button button = makeCardButton(row, col);
                pane.add(button, col, row);
            }
        }

        description = makeLabel("New Game Started");
        description.setFont(new Font("Comic Sans MS", 24));
        description.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        hbox.getChildren().setAll(side, pane, description);

        Scene scene = new Scene(hbox);
        stage.setTitle("Memory!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Code to flip over a card on the screen
     * @param col
     * @param row
     */
    public void makeMove(int col, int row){
        try{
            memory.flip(col, row);
            description.setText("Nice Move!\t      ");
        } catch (Exception e){
            description.setText("Invalid Move!\t      ");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}