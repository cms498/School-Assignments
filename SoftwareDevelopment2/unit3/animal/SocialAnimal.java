/**
 * This program houses the abstract SocialAnimal class which is an interface of an Animal
 * 
 * Social animals can spread rumors to other social animals using a tree like structure
 * 
 * Author: Chris Shepard
 */

package animal;

public abstract class SocialAnimal implements Animal{
    private String name;
    private SocialAnimal friend1;
    private SocialAnimal friend2;

    /**
     * basic constructor for a SocialAnimal
     * @param name
     */
    public SocialAnimal(String name){
        this.name = name;
    }

    /**
     * getter method for social animals name
     * @return animal name
     */
    public String getName() {
        return this.name;
    }

    /**
     * allows for printing of a social animal and the sounds it makes
     */
    @Override
    public String toString(){
        return getName() + " [" + makeSound() + "]";
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
            System.out.println(getName() + " hears " + last.makeSound());
        }
    }

    /**
     * Setter method for friend 1, which is the left node
     * @param friend1
     */
    public void setFriend1(SocialAnimal friend1){
        this.friend1 = friend1;
    }

    /**
     * Setter method for friend 2, which is the right node
     * @param friend2
     */
    public void setFriend2(SocialAnimal friend2){
        this.friend2 = friend2;
    }

    /**
     * getter method for friend 1
     * @return friend 1
     */
    public SocialAnimal getFriend1() {
        return friend1;
    }

    /**
     * getter method for friend 2
     * @return friend 2
     */
    public SocialAnimal getFriend2() {
        return friend2;
    }

    /**
     * Abstract method talkTo, all Social Animals must talk
     * @param animal
     */
    public abstract void talkTo(SocialAnimal animal);

    /**
     * Spread a rumor across the social animals, uses a tree like structure
     * Continues as long as the right or left node isn't null
     */
    public void spreadRumor(){
        SocialAnimal friend1 = getFriend1();
        SocialAnimal friend2 = getFriend2();
        if(friend1 != null ){
            this.talkTo(friend1);
        }
        if(friend2 != null){
            this.talkTo(friend2);
        }
        if(friend1 != null){
            friend1.spreadRumor();
        }
        if(friend2 != null){
            friend2.spreadRumor();
        }
    }
}