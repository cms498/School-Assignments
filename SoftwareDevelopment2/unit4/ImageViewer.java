import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("file:media/images/smb.gif");

        ImageView view = new ImageView(image);

        HBox hbox = new HBox();
        hbox.getChildren().setAll(view);
        
        Scene scene = new Scene(hbox);

        stage.setTitle("Images");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}