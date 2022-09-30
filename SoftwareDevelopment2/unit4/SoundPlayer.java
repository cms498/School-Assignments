import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer implements EventHandler<ActionEvent>{

    private MediaPlayer player;

    public SoundPlayer(MediaPlayer player){
        this.player = player;
    }

    @Override
    public void handle(ActionEvent event) {
        this.player.play();
    }
}