/**
 * This program houses the JUnit testing for the Log class
 * 
 * Author: Chris Shepard
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LogTest {
    //Class where all of the tests take place, covers edge cases and large numbers
    @Test
    public void negative_n(){
        //setup
        int n = -1;
        int b = 9;
        int expected = -1;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void n_is_1(){
        //setup
        int n = 1;
        int b = 9;
        int expected = 0;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void n_same_as_b(){
        //setup
        int n = 2;
        int b = 2;
        int expected = 1;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void round_result_down(){
        //setup
        int n = 10;
        int b = 2;
        int expected = 3;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void large_n(){
        //setup
        int n = 1000000;
        int b = 2;
        int expected = 19;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void large_edge_case(){
        //setup
        int n = 1000001;
        int b = 10;
        int expected = 6;
        //invoke
        int actual = Log.log(b, n);
        //analyze
        assertEquals(expected, actual);
    }
}
