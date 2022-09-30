package Assignment4_2;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Channel {
    private String description;
    private String imagePath;
    private String audioPath;
    private MediaPlayer player;
    
    public Channel(String description, String imagePath, String audioPath){
        this.description = description;
        this.imagePath = imagePath;
        this.audioPath = audioPath;
        String uri = new File(this.audioPath).toURI().toString();
        Media media = new Media(uri);
        this.player = new MediaPlayer(media);
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void startMedia(){
        this.player.play();
    }

    public void stopMedia(){
        this.player.stop();
    }

    public double getVolume(){
        return this.player.getVolume();
    }

    public void setVolume(double v){
        if(v < 0.0){
            v = 0.0;
        }
        if(v > 1.0){
            v = 1.0;
        }
        this.player.setVolume(v);
    }

    public void increaseVolume(){
        this.player.setVolume(player.getVolume() + 0.1);
    }

    public void decreaseVolume(){
        this.player.setVolume(player.getVolume() - 0.1);
    }
}