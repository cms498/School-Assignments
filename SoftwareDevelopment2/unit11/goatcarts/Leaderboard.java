package goatcarts;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * GUI representing the leaderboard in a Goat Cart race.
 * 
 * You are NOT allowed to change anything in this file except the one
 * line that instantiates your troll instance. It is marked with a todo.
 */
public class Leaderboard extends Application {

    /**
     * Inner class to put all the racer entry infor in one place.
     */
    private class RacerEntry {
        private Label racerName;
        private Label racerNumber;
        private Label racerTime;
        private Label racerLap;

        private RacerEntry () {
            racerName = Leaderboard.makeLabel ("...");
            racerNumber = Leaderboard.makeLabel ("##");
            racerNumber.setAlignment (Pos.CENTER_RIGHT);
            racerLap = Leaderboard.makeLabel ("0");
            racerTime = Leaderboard.makeLabel ("0.0");
        }
    }

    /**
     * Private variables
     */
    private TrollInterface troll;
    private GridPane racerPositions;
    private RacerEntry[] racers;
    private Label raceAnouncer;

    /**
     * Helper function to creat a styled label.
     * @param text Text the lable will display.
     * @return  A new label
     */
    private static Label makeLabel (String text) {
        Label label = new Label (text);
        label.setPadding (new Insets (5));
        label.setFont (new Font ("Comic Sans MS", 15));
        label.setMaxWidth (Double.POSITIVE_INFINITY);
        return label;
    }

    /**
     * Update the leaderboard with the racers currrnt postions and information.
     */
    private void updateRacers (){
        Platform.runLater (()-> { 
            System.out.println ("Updating Racers");
            // Get the current postions from the troll
            GoatCartInterface[] positions = troll.getPositions();
            // Updated the anouncer text with whatever the troll is saying
            raceAnouncer.setText (troll.getDialog());
            for (int i = 0; i < positions.length; i++) {
                GoatCartInterface racer = positions[i];
                if (racer != null) {
                    racers[i].racerNumber.setText (racer.getCartNumber() + "");
                    racers[i].racerName.setText (racer.getRacerName());
                    racers[i].racerTime.setText (racer.getRaceTime() + "");
                    int lap = racer.getLap();
                    // If the race is over, use fin as the lap
                    if (lap > troll.getNumLaps ()) {
                        racers[i].racerLap.setText ("Fin");
                    }
                    else {
                        racers[i].racerLap.setText (racer.getLap() + "");
                    }
                }
            }
        });
    }

   @Override
   public void init() throws Exception {
        super.init();
        // Intialzie any non-UI constructs

        troll = new Troll(); // TODO: Update with concrete Troll instance
        racers = new RacerEntry[troll.getNumRacers()];
   }

    @Override
    public void start(Stage stage) throws Exception {
        racerPositions = new GridPane();

        // Crete the leaderboard headers and add them to the leaderboard
        Label numHeader = makeLabel ("Cart#");
        Label racerNameHeader = makeLabel ("Racer Name                    ");
        Label lapHeader = makeLabel ("Lap");
        Label timeHeader = makeLabel ("Cart Time");        
        racerPositions.add (numHeader, 0, 0);
        racerPositions.add (racerNameHeader, 1, 0);
        racerPositions.add (lapHeader, 2, 0);
        racerPositions.add (timeHeader, 3, 0);

        // Add the elements of a racer to the leaderboard
        for (int i = 0; i < troll.getNumRacers(); i++) {
            racers[i] = new RacerEntry ();
            racerPositions.add (racers[i].racerNumber, 0, i + 1);
            racerPositions.add (racers[i].racerName, 1, i + 1);
            racerPositions.add (racers[i].racerLap, 2, i + 1);
            racerPositions.add (racers[i].racerTime, 3, i + 1);
        }

        // Add the announcer (status) to the leaderboard
        raceAnouncer = makeLabel (troll.getDialog());
        racerPositions.add (raceAnouncer, 0, troll.getNumRacers() + 2, 4, 1);

        // Show the leaderboard
        Scene scene = new Scene (racerPositions);
        stage.setTitle ("Goat Cart 5000");
        stage.setScene (scene);
        stage.show ();

        /*
        * The leaderboard updates once a second to ensure users have time to recognize
        * changes. Due to the speed of the racers, if an Observer was used the leaderboard
        * could change multiple times a second which would be very disorienting. Since 
        * sleep is used to limit the update rate, the update needs to occur in its own
        * thread.
        */
        new Thread (() -> {
            try {
                while (!troll.getRaceFinished ()) {
                    Thread.sleep (1000);
                    updateRacers();
                }
            } catch (InterruptedException ie) {}
        }).start ();

        // Once everything is set up, have the troll run the race. To make sure
        // it doesn't interfere with UI, run it in a new thread.
        new Thread (()->troll.runRace()).start ();
    }

    public static void main(String[] args) {
        launch (args);
    }
}