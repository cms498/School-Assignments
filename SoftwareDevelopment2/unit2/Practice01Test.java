/**
 * This program houses the test cases for Practice01.java
 * 
 * Author: Chris Shepard
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Practice01Test {
    @Test
    public void length0(){
        //setup
        int[] numbers = new int[0];
        String expected = "[]";
        //invoke
        String actual = Practice01.arrayToString(numbers);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void length1(){
        //setup
        int[] numbers = new int[]{8};
        String expected = "[8]";
        //invoke
        String actual = Practice01.arrayToString(numbers);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void lengthGreaterThen3(){
        //setup
        int[] numbers = new int[]{7, 3, 9, 2, 0, 3};
        String expected = "[7, 3, 9, 2, 0, 3]";
        //invoke
        String actual = Practice01.arrayToString(numbers);
        //analyze
        assertEquals(expected, actual);
    }
}
