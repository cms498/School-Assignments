package goatcarts;

/**
 * Interface for a Gooat Cart. Implementing this ensures your GoatCart will work
 * with the Troll and Leaderboard. You are not allowed to make any changes to this 
 * file.
 */
public interface GoatCartInterface extends Runnable {
    /**
     * Get the racer's name.
     * @return Racer's name.
     */
    String getRacerName ();

    /**
     * Find out the goat cart's race number.
     * @return The cart's number.
     */
    int getCartNumber ();

    /**
     * Get how long the cart has been racing. This also is used
     * to determine the carts position in the race.
     * @return
     */
    double getRaceTime ();

    /**
     * Get the cart's currnt lap number. When the race first starts
     * the cart is on lap 1.
     * @return The current lap number for this cart.
     */
    int getLap ();
}
