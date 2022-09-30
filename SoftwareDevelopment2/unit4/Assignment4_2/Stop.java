package Assignment4_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Stop implements EventHandler<ActionEvent>{
    private Channel channel;

    public Stop(Channel channel){
        this.channel = channel;
    }

    @Override
    public void handle(ActionEvent event) {
        channel.stopMedia();
    }
}