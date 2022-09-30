/**
 * This program houses the abstract Fighter class, which can attack, take damage and be printed
 * 
 * Author: Chris Shepard
 */

package SSB;

public abstract class Fighter {
    private int maxHP;
    private int currentHP;
    private String name;

    /**
     * Basic constructor for a fighter
     * @param name
     * @param maxHP
     */
    public Fighter(String name, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public abstract int attack();//abstract method, each fighter can attack differently

    public abstract void takeDamage(int damageDelt);//abstract method, each fighter can take damage in different ways

    /**
     * Reduces the current hp by a certain amount, prevents it from going below zero
     * @param amount
     */
    public void reduceHP(int amount){
        this.currentHP -= amount;
        if(this.currentHP < 0){
            this.currentHP = 0;
        }
    }

    /**
     * Returns true is the fighters health is below 1
     * @return
     */
    public boolean isUnconscious(){
        return this.currentHP < 1;
    }

    /**
     * getter for the current hp a fighter is at
     * @return current hp
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * getter for the max hp a fighter has
     * @return maxhp
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * getter for the fighters name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Used to print out the fighters name as well as total hp amount
     */
    @Override
    public String toString(){
        return getName() + "{ " + getCurrentHP() + " / " + getMaxHP() + " }";
    }
}
