package Assignment4_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class VolDown implements EventHandler<ActionEvent>{
    private Label label;
    private Channel currentChannel;

    public VolDown(Label label, Channel currentChannel){
        this.label = label;
        this.currentChannel = currentChannel;
    }
    
    @Override
    public void handle(ActionEvent event) {
        double currentVolume = this.currentChannel.getVolume();
        if(currentVolume > 0){
            int newVolume = (int)(currentVolume * 10) - 10;
            if(newVolume > 10){
                newVolume = 10;
            } else if (newVolume < 0){
                newVolume = 0;
            }
            this.currentChannel.decreaseVolume();
            String newVolumeString = newVolume + "";
            label.setText(newVolumeString);
        }
    }
}