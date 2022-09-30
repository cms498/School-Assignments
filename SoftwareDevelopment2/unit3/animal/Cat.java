/**
 * This program houses the Cat class, which is a social animal
 * 
 * Author: Chris Shepard
 */

package animal;

public class Cat extends SocialAnimal{
    /**
     * Constructor for the Cat class
     * @param name
     */
    public Cat(String name) {
        super(name);
    }

    /**
     * prints out the cat talking to other animals
     * @param animal
     */
    @Override
    public void talkTo(SocialAnimal animal){
        System.out.println(getName() + " purrs " + makeSound() +  " to " + animal.getName() + " with a big smile.");
    }

    /**
     * returns the sounds the animal makes
     */
    @Override
    public String makeSound() {
        return "meow";
    }
}