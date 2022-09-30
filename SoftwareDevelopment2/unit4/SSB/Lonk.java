/**
 * This program houses the Lonk class who is a fighter
 * 
 * Author: Chris Shepard
 */

package SSB;

import java.util.Random;

public class Lonk extends Fighter{
    Random RNG = new Random();

    /**
     * Basic constructor for lonk
     */
    public Lonk() {
        super("Lonk", 150);
    }

    /**
     * His attacks only do 45 damage
     */
    @Override
    public int attack() {
        return 45;
    }

    /**
     * He has a 50% chance to block and reduce the damage taken by half
     */
    @Override
    public void takeDamage(int damageDelt) {
        int blockChance = RNG.nextInt(8);
        if(blockChance > 4){
            damageDelt /= 2;
            this.reduceHP(damageDelt);
            System.out.println(this.getName() + " blocked and took " + damageDelt + " damage");
        } else {
            this.reduceHP(damageDelt);
            System.out.println(this.getName() + " took " + damageDelt + " damage");
        }
    }
}