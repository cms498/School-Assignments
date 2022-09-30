/**
 * This program houses the Manio class who is a fighter
 * 
 * Author: Chris Shepard
 */

package SSB;

import java.util.Random;

public class Manio extends Fighter{
    Random RNG = new Random();

    /**
     * Basic construtor Manio
     */
    public Manio() {
        super("Manio", 100);
    }

    /**
     * Manio does between 25 and 50 damage
     */
    @Override
    public int attack() {
        int amount = RNG.nextInt(26) + 25;
        return amount;
    }

    /**
     * Manio has a 25% chance to dodge and take zero damage
     */
    @Override
    public void takeDamage(int damageDelt) {
        int dodgeChance = RNG.nextInt(8);
        if(dodgeChance > 2){
            this.reduceHP(damageDelt);
            System.out.println(this.getName() + " took " + damageDelt + " damage");
        } else {
            damageDelt = 0;
            System.out.println(this.getName() + " dodged and took " + damageDelt + " damage");
        }
    }   
}