import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneActivity extends Application{

    public static Label setLabel(String text){
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Arial", 36));
        label.setPadding(new Insets(20));
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();

        Label top = setLabel("123.456");
        top.setAlignment(Pos.CENTER_RIGHT);
        top.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        top.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        gridPane.add(top, 0, 0, 4, 1);
        
        gridPane.add(setLabel("AC"), 0, 1, 2, 1);
        gridPane.add(setLabel("%"), 2, 1);
        gridPane.add(setLabel("/"), 3, 1);

        gridPane.add(setLabel("7"), 0, 2);
        gridPane.add(setLabel("8"), 1, 2);
        gridPane.add(setLabel("9"), 2, 2);
        gridPane.add(setLabel("x"), 3, 2);
        
        gridPane.add(setLabel("4"), 0, 3);
        gridPane.add(setLabel("5"), 1, 3);
        gridPane.add(setLabel("6"), 2, 3);
        gridPane.add(setLabel("-"), 3, 3);

        gridPane.add(setLabel("1"), 0, 4);
        gridPane.add(setLabel("2"), 1, 4);
        gridPane.add(setLabel("3"), 2, 4);
        gridPane.add(setLabel("+"), 3, 4);

        gridPane.add(setLabel("0"), 0, 5, 2, 1);
        gridPane.add(setLabel("."), 2, 5);
        gridPane.add(setLabel("="), 3, 5);


        Scene scene = new Scene(gridPane);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}