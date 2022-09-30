import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application{

    private static Button makeButton(String text, String path){
        Button button = new Button(text);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        button.setAlignment(Pos.CENTER);

        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        SoundPlayer sp = new SoundPlayer(player);
        button.setOnAction(sp);
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        box.getChildren().addAll(
            makeButton("Chomp", "media/sounds/chomp.wav"),
            makeButton("Eat", "media/sounds/eat.wav"),
            makeButton("End", "media/sounds/end.wav"),
            makeButton("Start", "media/sounds/start.wav")
        );
        
        Scene scene = new Scene(box);
        stage.setTitle("Sounds");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}