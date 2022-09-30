import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Clear implements EventHandler<ActionEvent>{
    private Label label;

    public Clear(Label label){
        this.label = label;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.label.setText("");
    }
}