package Assignment4_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Change implements EventHandler<ActionEvent>{
    private Label label;
    private Channel[] channels;
    private Button button;
    private Image image;
    private ImageView imageView;
    private Channel currentChannel;

    public Change(Channel[] channels, Button button, Image image, ImageView imageView, Label label, Channel currentChannel){
        this.channels = channels;
        this.button = button;
        this.image = image;
        this.imageView = imageView;
        this.label = label;
        this.currentChannel = currentChannel;
    }

    private void changeChannel(String num){
        Channel newChannel = channels[Integer.parseInt(num)];
        if(newChannel != this.currentChannel){
            this.currentChannel.stopMedia();
            double volume = this.currentChannel.getVolume();
            newChannel.setVolume(volume);
            newChannel.startMedia();
            String imagePath = channels[Integer.parseInt(num)].getImagePath();
            image = new Image(imagePath);
            imageView.setImage(image);
            String description = channels[Integer.parseInt(num)].getDescription();
            label.setText(description);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        String num = button.getText();
        changeChannel(num);
    }
}