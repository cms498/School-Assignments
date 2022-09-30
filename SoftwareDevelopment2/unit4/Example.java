import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Example extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("Label for the scene");
        Scene scene = new Scene(label);
        
        stage.setScene(scene);
        stage.setTitle("Stage Title");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
