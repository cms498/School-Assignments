package reversi.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import reversi.model.Square;
import reversi.model.SquareObserver;

public class SquareChanger implements SquareObserver{
    private final Button button;

    public SquareChanger(Button button){
        this.button = button;
    }

    @Override
    public void squareChanged(Square square) {
        switch(square.getOccupyingColor()){
            case EMPTY:
                button.setGraphic(new ImageView(ReversiGUI.BLANK));
                break;
            case WHITE:
                button.setGraphic(new ImageView(ReversiGUI.WHITE_PIECE));
                break;
            case BLACK:
                button.setGraphic(new ImageView(ReversiGUI.BLACK_PIECE));
                break;
        }
    }
}