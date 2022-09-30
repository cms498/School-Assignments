/**
 * This program houses the tiger class which implements the animal interfact
 * 
 * Author: Chris Shepard
 */

package animal;

public class Tiger implements Animal{
    private int weight;

    /**
     * Basic constructor for the tiger
     * @param weight
     */
    public Tiger(int weight){
        this.weight = weight;
    }

    /**
     * returns the sound a tiger makes
     */
    @Override
    public String makeSound() {
        return "grrrrr";
    }

    /**
     * CODE PROVIDED BY PROFESSOR ST JACQUES IN THE DISCORD
     * 
     * hear method resizes the animals array to other the animal
     * in position zero is being listened too
     */
    @Override
    public void hear(Animal[] animals) {
        if(animals != null && animals.length > 0) {
            int length = animals.length;
            // get the last animal
            Animal last = animals[length - 1];
            // copy all of the other animals into a smaller array
            Animal[] rest = new Animal[length - 1];
            for(int i=0; i<length-1; i++) {
              rest[i] = animals[i];
            }
            // call hear on the last animal with the others
            last.hear(rest);
            // finally, print a message that YOU hear the last animal
            System.out.println("A tiger hears " + last.makeSound());
        }
    }

    /**
     * getter method for tigers weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Allows for the ability to print out a tiger
     */
    @Override
    public String toString(){
        return getWeight() + " lb tiger [" + makeSound() + "]";
    }
}