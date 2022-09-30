package chevre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The hottest club in Goatsville.
 */
public class ClubChevre {
    /**
     * The maximum total occupancy of the club.
     */
    public static final int MAXIMUM_OCCUPANCY = 10;

    /**
     * The line in which the goats wait before being let in.
     */
    private final List<Goat> line;

    /**
     * The dance floor.
     */
    private final Set<Goat> danceFloor;

    /**
     * The bar, at which goats recuperate between dancing sessions.
     */
    private final Set<Goat> bar;

    private TrollBouncer bouncer;

    /**
     * Creates the club.
     */
    public ClubChevre() {
        line = new ArrayList<>();
        danceFloor = new HashSet<>();
        bar = new HashSet<>();
        bouncer = null;
    }

    public void setBouncer(TrollBouncer bouncer) {
        this.bouncer = bouncer;
    }

    public void leaveClub(){
        synchronized(bouncer){
            bouncer.notify();
        }
    }

    /**
     * Returns true if the club is at or over capacity.
     *
     * @return True if the club is full, false otherwise.
     */
    public synchronized boolean isAtCapacity() {
        return numberOfDancingGoats() + numberOfGoatsAtBar()
                >= MAXIMUM_OCCUPANCY;
    }

    //
    // line related methods
    //

    /**
     * Adds a goat to the back of the line outside of the club.
     *
     * @param goat The goat getting into the line.
     */
    public synchronized void getInLine(Goat goat) {
        line.add(goat);
    }

    /**
     * Returns the number of goats currently waiting in line to get into the
     * club.
     *
     * @return The number of goats currently in line.
     */
    public synchronized int numberOfGoatsInLine() {
        return line.size();
    }

    /**
     * Returns the goat at the specified position in line.
     *
     * @param position The position of the goat of interest.
     * @return The goat standing at the specified position in line.
     */
    public synchronized Goat getGoatAtPosition(int position) {
        return line.get(position);
    }

    /**
     * Removes the specified goat from the line, ostensibly when the goat is
     * chosen to enter the club.
     *
     * @param goat The goat to remove from the line.
     */
    public synchronized void removeGoatFromLine(Goat goat) {
        line.remove(goat);
    }

    //
    // dance floor related methods
    //

    /**
     * Called by a {@link Goat} that wishes to start dancing.
     *
     * @param goat The {@link Goat} about to dance.
     * @return True if the {@link Goat} can fit onto the dance floor, and
     * false otherwise.
     */
    public synchronized void startDancing(Goat goat) {
        danceFloor.add(goat);
    }

    /**
     * Called by a {@link Goat} that wishes to stop dancing.
     *
     * @param goat The {@link Goat} that is leaving the dance floor.
     */
    public synchronized void stopDancing(Goat goat) {
        danceFloor.remove(goat);
    }

    /**
     * Returns the number of {@link Goat Goats} currently dancing on the
     * dance floor.
     *
     * @return The number of dancing goats.
     */
    public synchronized int numberOfDancingGoats() {
        return danceFloor.size();
    }

    //
    // bar related methods
    //

    /**
     * A goat sits at the bar to recharge its energy.
     *
     * @param goat The goat that takes a seat at the bar.
     */
    public synchronized void sidleUpToBar(Goat goat) {
        bar.add(goat);
    }

    /**
     * A goat leaves the bar to head back to the dance floor.
     *
     * @param goat The goat that leaves the bar and heads back to the dance
     *             floor.
     */
    public synchronized void getBackToDancing(Goat goat) {
        bar.remove(goat);
        danceFloor.add(goat);
    }

    /**
     * The number of goats currently sitting at the bar.
     *
     * @return The number of goats currently sitting at the bar.
     */
    public synchronized int numberOfGoatsAtBar() {
        return bar.size();
    }

    public synchronized List<Goat> getLine() {
        return line;
    }

    public Set<Goat> getDanceFloor() {
        return danceFloor;
    }
}