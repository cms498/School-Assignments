package animal;

public class AnimalMain {

    // Uncomment test1_2() when you debug makeSound and hear
    public static void test1_2(){
        Animal tiger1 = new Tiger(300);
        Animal tiger2 = new Tiger(300);
        SocialAnimal happy = new Dog("Happy");
        SocialAnimal lucky = new Dog("Lucky");
        SocialAnimal milky = new Cat("Milky");
        
        Animal[] animals = {tiger1, happy, lucky, tiger2, milky};
        

        System.out.println("1. Testing makeSound and toString ...");
        for(int i=0; i<animals.length; i++){
            System.out.println(animals[i].makeSound());
            System.out.println(animals[i]);
        }
        
        SocialAnimal yoda = new Cat("Yoda");
        System.out.println("\n2. Testing Yoda hearing animal sounds ...");
        yoda.hear(animals);
    }

    // Uncomment test3() when you do activity 4. 
    
    public static void test3(){
        SocialAnimal dog1 = new Dog("Dog1");
        SocialAnimal dog2 = new Dog("Dog2");
        SocialAnimal dog3 = new Dog("Dog3");
        SocialAnimal dog4 = new Dog("Dog4");
        SocialAnimal dog5 = new Dog("Dog5");
        SocialAnimal cat1 = new Cat("Cat1");
        SocialAnimal cat2 = new Cat("Cat2");
        SocialAnimal cat3 = new Cat("Cat3");
        SocialAnimal cat4 = new Cat("Cat4");
        SocialAnimal cat5 = new Cat("Cat5");
    
        // Create a social network using the diagram provided in the assignment document
        dog1.setFriend1(dog2);
        dog1.setFriend2(cat1);
        dog2.setFriend1(cat2);
        cat2.setFriend1(dog4);
        cat2.setFriend2(dog5);
        cat1.setFriend1(cat3);
        cat1.setFriend2(dog3);
        dog3.setFriend1(cat4);
        dog3.setFriend2(cat5);

        System.out.println("\n3. Testing dog1 spreading a rumor....");
        dog1.spreadRumor();
    }
    
    public static void main(String[] args){
        test1_2();
        test3();
    }
}
