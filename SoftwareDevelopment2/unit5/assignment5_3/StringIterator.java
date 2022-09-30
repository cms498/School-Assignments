/**
 * This program allows for the creation of a StringIterator
 * which checks for the end of the string and gets the next
 * value in a string array
 * 
 * Author: Chris Shepard
 */

package assignment5_3;

import java.util.Iterator;

public class StringIterator implements Iterator<String>{
    private String[] splitted;
    private int index;
    private int size;

    /**
     * Basic constructor, sets index and size given a string array
     * @param splitted
     */
    public StringIterator(String[] splitted){
        this.splitted = splitted;
        this.size = splitted.length;
        this.index = 0;
    }

    /**
     * Overridden method from Iterator, determines if there is
     * another value in the String
     */
    @Override
    public boolean hasNext() {
        return index < size;
    }

    /**
     * Override method from next, gets the string from the splitted array
     * and return that string value
     */
    @Override
    public String next() {
        String value = splitted[index];
        if(value == null){
            throw new IndexOutOfBoundsException(value);
        }
        index++;
        return value;
    }
}