import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application{

    public static Label setLabel(String text, int fontSize){
        Label label = new Label(text);
        label.setFont(new Font("Arial", fontSize));
        label.setAlignment(Pos.CENTER);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    public static Button setButton(String text){
        Button button = new Button(text);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox main = new VBox();

        VBox labels = new VBox();
        Label hello = setLabel("HELLO MY NAME IS", 30);
        Label name = setLabel("NAME", 50);
        labels.getChildren().addAll(hello, name);

        TextField field = new TextField();
        field.setPromptText("Type name");

        Button update = setButton("Update Name Tag");
        Updater updater1 = new Updater(field, name);
        update.setOnAction(updater1);

        Button clear = setButton("Clear");
        Clear clear1 = new Clear(name);
        clear.setOnAction(clear1);

        main.getChildren().addAll(labels, field, update, clear);
        
        Scene scene = new Scene(main);

        stage.setTitle("Name Tag GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}