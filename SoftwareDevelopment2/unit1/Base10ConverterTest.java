/**
 * This program houses all of the test cases for the Base10Converter class
 * 
 * Author: Chris Shepard
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Base10ConverterTest {
    @Test
    public void chartoIntegerEdgeCase() {
        //setup
        char digit = '0';
        int expected = 0;
        //invoke
        int actual = Base10Converter.charToInteger(digit);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void chartoIntegerBigEdge() {
        //setup
        char digit = '9';
        int expected = 9;
        //invoke
        int actual = Base10Converter.charToInteger(digit);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base10EndianTrue(){
        //setup
        char[] digits = new char[]{'5', '4', '6', '7'};
        int base = 10;
        boolean encoding = true;
        int expected = 5467;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base10EndianFalse(){
        //setup
        char[] digits = new char[]{'5', '4', '6', '7'};
        int base = 10;
        boolean encoding = false;
        int expected = 7645;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base8EndianTrue(){
        //setup
        char[] digits = new char[]{'5', '4', '6', '7'};
        int base = 8;
        boolean encoding = true;
        int expected = 2871;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base8EndianFalse(){
        //setup
        char[] digits = new char[]{'5', '4', '6', '7'};
        int base = 8;
        boolean encoding = false;
        int expected = 4005;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base2EndianTrue(){
        //setup
        char[] digits = new char[]{'1', '0', '1', '1'};
        int base = 2;
        boolean encoding = true;
        int expected = 11;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void base2EndianFalse(){
        //setup
        char[] digits = new char[]{'1', '0', '1', '1'};
        int base = 2;
        boolean encoding = false;
        int expected = 13;
        //invoke
        int actual = Base10Converter.arrayToInteger(digits, base, encoding);
        //analyze
        assertEquals(expected, actual);
    }
}
