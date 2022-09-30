/**
 * This program houses the componets to create a player bet
 * 
 * Author: Chris Shepard
 */

package Assignment2_3;

public class Bet {
    private int bet;
    private String location;

    /**
     * Creates a Bet object, given how much the bet is and where it is on the roulette wheel
     * @param bet
     * @param location
     */
    public Bet(int bet, String location){
        this.bet = bet;
        this.location = location;
    }

    //accessor method for players bet
    public int getBet() {
        return bet;
    }

    //accessor method for players bet location
    public String getLocation() {
        return location;
    }
}