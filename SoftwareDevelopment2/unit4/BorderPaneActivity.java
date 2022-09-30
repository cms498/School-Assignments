import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneActivity extends Application{

    public static Label setLabel(String text, Color background, Color textColor){
        Label label = new Label(text);
        label.setFont(new Font("Comic Sans MS", 48));
        label.setPadding(new Insets(40));
        label.setAlignment(Pos.CENTER);
        label.setTextFill(textColor);
        label.setBackground(new Background(new BackgroundFill(background, new CornerRadii(10), Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BISQUE, BorderStrokeStyle.DOTTED, new CornerRadii(10), BorderStroke.THICK)));
        label.setMaxHeight(Double.POSITIVE_INFINITY);
        label.setMaxWidth(Double.POSITIVE_INFINITY);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label label1 = setLabel("Top", Color.RED, Color.WHEAT);
        label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10), BorderStroke.THICK)));
        Label label2 = setLabel("Right", Color.BLUE, Color.PURPLE);
        Label label3 = setLabel("Bottom", Color.YELLOWGREEN, Color.BLACK);
        label3.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THICK)));
        Label label4 = setLabel("Left", Color.BROWN, Color.BLACK);
        Label label5 = setLabel("Center", Color.GREEN, Color.BLACK);

        BorderPane pane = new BorderPane();
        pane.setTop(label1);
        pane.setRight(label2);
        pane.setBottom(label3);
        pane.setLeft(label4);
        pane.setCenter(label5);

        //pane.getChildren().addAll(label1, label2, label3, label4, label5);

        Scene scene = new Scene(pane);

        stage.setTitle("Label Activity Title");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}