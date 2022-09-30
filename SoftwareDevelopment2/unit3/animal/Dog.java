/**
 * This program houses the Dog class, which is a social animal
 * 
 * Author: Chris Shepard
 */

package animal;

public class Dog extends SocialAnimal{
    /**
     * Constructor for the Dog class
     * @param name
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * prints out the dog talking to other animals
     * @param animal
     */
    @Override
    public void talkTo(SocialAnimal animal){
        System.out.println(getName() + " barks " + makeSound() + " to " + animal.getName() + " waving its tail.");
    }

    /**
     * returns the sounds the animal makes
     */
    @Override
    public String makeSound() {
        return "woof";
    }
}