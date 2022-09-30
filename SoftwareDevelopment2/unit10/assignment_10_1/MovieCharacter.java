/**
 * This program uses an array stream to print out a list of movie characters
 * there quotes and what movie they said them in
 * 
 * Author: Chris Shepard
 */

package assignment_10_1;

import java.util.Arrays;

public abstract class MovieCharacter {
    private String name;

    /**
     * Basic construct, only takes in the characters name
     * @param name
     */
    public MovieCharacter(String name){
        this.name = name;
    }

    /**
     * getter method for the characters name
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * allows for printing of a character
     */
    @Override
    public String toString(){
        return this.name;
    }

    public abstract String quote(); //abstract method for the characters quote
    public abstract String movie(); //abstract method for the characters movie

    /**
     * Main method where the character list is initilized, and the lambda for printing is
     * also created, each character is made using an anonymous class
     * @param args
     */
    public static void main(String[] args) {
        MovieCharacter[] characterList = new MovieCharacter[3];
        characterList[0] = new MovieCharacter("Dwayne Johnson") {
            @Override
            public String quote() {
                return "As your good friend, you need a new catchphrase.";
            }
            @Override
            public String movie() {
                return "GI Joe: Retaliation";
            }
        };
        characterList[1] = new MovieCharacter("Vin Diesel") {
            @Override
            public String quote() {
                return "You know this ain't no 10-second race, I've got nothing but time.";
            }
            @Override
            public String movie() {
                return "Fast & Furious";
            }
        };
        characterList[2] = new MovieCharacter("Kevin Hart") {
            @Override
            public String quote() {
                return "Did I die and turn into a small muscular boy scout?";
            }
            @Override
            public String movie() {
                return "Jumanji II: The Next level";
            }
        };
        Arrays.stream(characterList).
        forEach(character -> System.out.println(character.name + " said <" + character.quote() + "> in " + character.movie()));
    }
}