import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application{

    @Override
    public void start(Stage stage){
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
            new ImageView("file:media/images/emojis/headred.png"),
            new ImageView("file:media/images/emojis/mouthdelerious.png"),
            new ImageView("file:media/images/emojis/browsangry.png"),
            new ImageView("file:media/images/emojis/eyesgreen.png")
        );

        Scene scene = new Scene(pane);
        stage.setTitle("Emoji");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}