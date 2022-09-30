/**
 * This program houses the Animal interface
 * 
 * Author: Chris Shepard
 */

package animal;

public interface Animal {
    public abstract String makeSound();
    public abstract void hear(Animal[] animals);
}