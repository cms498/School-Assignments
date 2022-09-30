/**
 * Test cases for IterativeFib Class, covers edge cases
 * 
 * Author: Chris Shepard
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class IterativeFibTest {
    @Test
    public void less_then_1() {
        //setup
        int n = 0;
        int expected = -1;
        //invoke
        int actual = IterativeFib.fib(n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void n_is_1() {
        //setup
        int n = 1;
        int expected = 0;
        //invoke
        int actual = IterativeFib.fib(n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void n_is_10() {
        //setup
        int n = 10;
        int expected = 34;
        //invoke
        int actual = IterativeFib.fib(n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void n_is_second_1() {
        //setup
        int n = 3;
        int expected = 1;
        //invoke
        int actual = IterativeFib.fib(n);
        //analyze
        assertEquals(expected, actual);
    }
}
