package Assignment4_2;

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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TV extends Application{
    private Channel[] channels = {
        new Channel("0 - Ducktales", "file:media_4_2/media/images/tv_shows/ducktales.jpg", "media_4_2/media/sounds/tv_shows/ducktales.mp3"),
        new Channel("1 - Garfield", "file:media_4_2/media/images/tv_shows/garfield.jpg", "media_4_2/media/sounds/tv_shows/garfield.mp3"),
        new Channel("2 - GI Joe", "file:media_4_2/media/images/tv_shows/gi_joe.jpg", "media_4_2/media/sounds/tv_shows/gi_joe.mp3"),
        new Channel("3 - He Man", "file:media_4_2/media/images/tv_shows/he_man.jpg", "media_4_2/media/sounds/tv_shows/he_man.mp3"),
        new Channel("4 - Pinky and the Brain", "file:media_4_2/media/images/tv_shows/pinky_and_the_brain.jpg", "media_4_2/media/sounds/tv_shows/pinky_and_the_brain.mp3"),
        new Channel("5 - Real GB", "file:media_4_2/media/images/tv_shows/realgb.png", "media_4_2/media/sounds/tv_shows/realgb.mp3"),
        new Channel("6 - Smurfs", "file:media_4_2/media/images/tv_shows/smurfs.jpg", "media_4_2/media/sounds/tv_shows/smurfs.mp3"),
        new Channel("7 - Thundercats", "file:media_4_2/media/images/tv_shows/thundercats.jpg", "media_4_2/media/sounds/tv_shows/thundercats.mp3"),
        new Channel("8 - Transformers", "file:media_4_2/media/images/tv_shows/transformers.jpg", "media_4_2/media/sounds/tv_shows/transformers.mp3"),
        new Channel("9 - Voltron", "file:media_4_2/media/images/tv_shows/voltron.jpg", "media_4_2/media/sounds/tv_shows/voltron.mp3"),
    };

    private Channel currentChannel = channels[0];

    private static Label makeLabel(String text){
        Font f = Font.loadFont("file:media/fonts/digital-7-mono.ttf", 55);
        Label label = new Label(text);
        label.setTextFill(Color.RED);
        label.setPadding(new Insets(20));
        label.setFont(f);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        return label;
    }

    private static Button makeButton(String text){
        Button button = new Button(text);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        button.setStyle("-fx-font-size: 3.64em; ");
        button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox mainBox = new VBox();

        Label description = makeLabel("0 - Ducktales");

        HBox midBox = new HBox();

        Image image = new Image("file:media_4_2/media/images/tv_shows/ducktales.jpg");
        ImageView view = new ImageView(image);

        GridPane panes = new GridPane();

        Button one = makeButton("1");
        Change c1 = new Change(channels, one, image, view, description, currentChannel);
        one.setOnAction(c1);
        panes.add(one, 0, 1);

        Button two = makeButton("2");
        Change c2 = new Change(channels, two, image, view, description, currentChannel);
        two.setOnAction(c2);
        panes.add(two, 1, 1);

        Button three = makeButton("3");
        Change c3 = new Change(channels, three, image, view, description, currentChannel);
        three.setOnAction(c3);
        panes.add(three, 2, 1);

        Button four = makeButton("4");
        Change c4 = new Change(channels, four, image, view, description, currentChannel);
        four.setOnAction(c4);
        panes.add(four, 0, 2);

        Button five = makeButton("5");
        Change c5 = new Change(channels, five, image, view, description, currentChannel);
        five.setOnAction(c5);
        panes.add(five, 1, 2);

        Button six = makeButton("6");
        Change c6 = new Change(channels, six, image, view, description, currentChannel);
        six.setOnAction(c6);
        panes.add(six, 2, 2);

        Button seven = makeButton("7");
        Change c7 = new Change(channels, seven, image, view, description, currentChannel);
        seven.setOnAction(c7);
        panes.add(seven, 0, 3);

        Button eight = makeButton("8");
        Change c8 = new Change(channels, eight, image, view, description, currentChannel);
        eight.setOnAction(c8);
        panes.add(eight, 1, 3);

        Button nine = makeButton("9");
        Change c9 = new Change(channels, nine, image, view, description, currentChannel);
        nine.setOnAction(c9);
        panes.add(nine, 2, 3);

        Button zero = makeButton("0");
        Change c0 = new Change(channels, zero, image, view, description, currentChannel);
        zero.setOnAction(c0);
        panes.add(zero, 0, 4, 2, 1);

        Button off = makeButton("X");
        Stop stop = new Stop(currentChannel);
        off.setOnAction(stop);
        panes.add(off, 2, 4);

        Label num = makeLabel("0");
        num.setAlignment(Pos.CENTER);
        panes.add(num, 2, 5);

        Button down = makeButton("-");
        VolDown volDown = new VolDown(num, currentChannel);
        down.setOnAction(volDown);
        panes.add(down, 0, 5);

        Button up = makeButton("+");
        VolUp volUp = new VolUp(num, currentChannel);
        up.setOnAction(volUp);
        panes.add(up, 1, 5);


        midBox.getChildren().setAll(view, panes);

        mainBox.getChildren().setAll(description, midBox);

        Scene scene = new Scene(mainBox);

        stage.setTitle("Saturday Morning TV");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}