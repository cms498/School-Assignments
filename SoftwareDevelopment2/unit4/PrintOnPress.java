import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PrintOnPress implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Event Received: " + event);
    }
}