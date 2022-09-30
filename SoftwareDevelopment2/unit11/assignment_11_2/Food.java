/**
 * This program represents the Food object, it can be printed
 * 
 * Author: Chris Shepard
 */

package assignment_11_2;

public class Food {
    private String name;
    private int servings;

    /**
     * Basic constructor, initilizes values
     * @param name
     * @param servings
     */
    public Food(String name, int servings){
        this.name = name;
        this.servings = servings;
    }

    /**
     * getter method for the foods name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for the foods servings
     * @return servings
     */
    public int getServings() {
        return servings;
    }

    @Override
    public String toString(){ // allows for food to be printed
        return this.servings + " servings of " + this.name;
    }
}