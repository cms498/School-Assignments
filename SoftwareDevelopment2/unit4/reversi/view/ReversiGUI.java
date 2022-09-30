package reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import reversi.model.Reversi;
import reversi.model.Square;

public class ReversiGUI extends Application{
    static final Image BLACK_PIECE = new Image("file:media/images/reversi/blackpiece.png");
    static final Image WHITE_PIECE = new Image("file:media/images/reversi/whitepiece.png");
    static final Image SQUARE = new Image("file:media/images/reversi/square.png");
    static final Image BLANK = new Image("file:media/images/reversi/blank.png");

    private Reversi reversi;
    // private Label status;
    // private Label player1Score;
    // private Label player2Score;

    private Button makeReversiButton(int row, int col){
        Button button = new Button("");
        button.setBackground(
            new Background(
                new BackgroundImage(
                    SQUARE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
                    BackgroundPosition.CENTER, BackgroundSize.DEFAULT)
                )
            );
        Square square = reversi.getSquare(row, col);
        SquareChanger changer = new SquareChanger(button);
        square.register(changer);
        
        switch(square.getOccupyingColor()){
            case EMPTY:
                button.setGraphic(new ImageView(BLANK));
                break;
            case WHITE:
                button.setGraphic(new ImageView(WHITE_PIECE));
                break;
            case BLACK:
                button.setGraphic(new ImageView(BLACK_PIECE));
                break;
        }
        //button.setPrefSize(72, 72);
        button.setPadding(Insets.EMPTY);
        MoveMaker moveMaker = new MoveMaker(row, col, this);
        button.setOnAction(moveMaker);
        return button;
    }

    public void makeMove(int row, int col){
        try {
            reversi.move(row, col);
        } catch (Exception e) {
            System.err.println("BAD MOVE!");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        reversi = new Reversi();
        //makeMove(5, 3);
        GridPane pane = new GridPane();
        for(int row = 0; row < Reversi.ROWS; row++){
            for(int col = 0; col < Reversi.COLS; col++){
                Button button = makeReversiButton(row, col);
                pane.add(button, col, row);
            }
        }
        Scene scene = new Scene(pane);
        stage.setTitle("Reversi!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
