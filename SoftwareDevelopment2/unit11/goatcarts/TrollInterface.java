package goatcarts;

/**
 * Interface for the Troll. Implementing this ensures your troll will work
 * with the Leaderboard. You are not allowed to make any changes to this 
 * file.
 */
public interface TrollInterface{
    /**
     * Find out if the race is over.
     * @return True if the race has finished, false otherwise
     */
    boolean getRaceFinished ();

    /**
     * Get a list of all the goat carts sorted by time. Due to the way
     * the race is run, the goat cart with the smallest time will be in
     * first place. 
     * 
     * Implementation Hint: Sort a copy of any interal array/collection
     * and return the copy.
     * @return A list of racers in current position order (I.E. Frist is
     * index 0, Second is index 1, etc.)
     */
    GoatCartInterface[] getPositions ();

    /**
     * Find out the number of goat carts that are ready to race.
     * @return The number of racers currently ready to race.
     */
    int getNumRacers ();

    /**
     * Get the number of lap in the race.
     * @return Number of laps in the race.
     */
    int getNumLaps ();

    /**
     * The troll is the announcer for the race. See what they are saying
     * right now.
     * @return The trolls current dialog.
     */
    String getDialog (); 

    /**
     * The troll is in crontrol of the race. They accept cart registrations,
     * strat the race, and make announcements. This is all done from the 
     * runRace method.
     */
    void runRace ();
}
