/**
 * This program allows you to iterate over a string printing
 * each individual word on a new line
 * 
 * Author: Chris Shepard
 */

package assignment5_3;

import java.util.Iterator;

public class IterableString implements Iterable<String>{
    private String[] splitted;

    /**
     * Basic constructor, takes in a string and splits in by spaces
     * @param s
     */
    public IterableString(String s){
        String string = s;
        this.splitted = string.split(" ");
    }

    /**
     * Creates a new StringIterator iterator
     */
    @Override
    public Iterator<String> iterator() {
        return new StringIterator(this.splitted);
    }

    /**
     * Main functions, tests IterableString for printing purposes and testing
     * @param args
     */
    public static void main(String[] args) {
        for(String word : new IterableString("Hello, iterate me.")){
            System.out.println(word);
        }

        for(String word : new IterableString("words spaces, asdasd")){
            System.out.println(word);
        }

        for(String word : new IterableString("123! false asdfas.;;';'; ")){
            System.out.println(word);
        }
    }
}