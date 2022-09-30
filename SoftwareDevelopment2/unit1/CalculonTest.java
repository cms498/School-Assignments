import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CalculonTest {
    @Test
    public void add(){
        //setup
        double x = 10.7;
        double y = 5.5;
        double expected = x + y;
        //invoke
        double actual = Calculon.add(x, y);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void sub(){
        //setup
        double x = 10.7;
        double y = 5.5;
        double expected = x - y;
        //invoke
        double actual = Calculon.subtract(x, y);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void mult(){
        //setup
        double x = 10.7;
        double y = 5.5;
        double expected = x * y;
        //invoke
        double actual = Calculon.multiply(x, y);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void divide(){
        //setup
        double x = 10.7;
        double y = 5.5;
        double expected = x / y;
        //invoke
        double actual = Calculon.divide(x, y);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void power(){
        //setup
        double x = 10.7;
        int y = 5;
        double expected = 140255.173;
        //invoke
        double actual = Calculon.raise(x, y);
        //analyze
        assertEquals(expected, actual, 0.001d);
    }
}
