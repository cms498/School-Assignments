package assignment5_1.view;

import assignment5_1.model.HiLo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HiLoGUI extends Application{
    private TextField text;
    private Label hint;
    private Label availableGuesses;
    
    @Override
    public void start(Stage stage){

        HiLo hilo = new HiLo();

        VBox vbox = new VBox();
        
        text = new TextField("Enter a number 1-100.");
        TextFieldHandler TFH = new TextFieldHandler(text, hilo);
        text.setOnAction(TFH);

        hint = makeLabel("Game has not started yet.");
        availableGuesses = makeLabel(HiLo.MAX_TRIES + " guesses left.");
        vbox.getChildren().addAll(text, hint, availableGuesses);
        vbox.setPrefWidth(200);

        GUIUpdater guiUpdater = new GUIUpdater(hint, availableGuesses, text);
        hilo.register(guiUpdater);

        stage.setScene(new Scene(vbox));
        stage.setTitle("High Low Game");
        stage.show();
    }

    public Label getHint(){
        return this.hint;
    }
    public Label getAvailableGuesses(){
        return this.availableGuesses;
    }
    public TextField getText(){
        return this.text;
    }

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}






