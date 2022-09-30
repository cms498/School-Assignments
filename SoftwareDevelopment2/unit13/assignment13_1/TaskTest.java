package assignment13_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TaskTest {
    /**
     * This test is for the one is the problem description
     */
    @Test
    public void list6Time(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundry", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));

        ArrayList<Task> subset = (ArrayList<Task>) Task.sort(tasks, 6);
        String actual = subset.toString();
        String expected = "[Sweep(1 hour), Mop(2 hour), Laundry(3 hour)]";
        assertEquals(expected, actual);
    }
    /**
     * This test covers if the input list is empty
     */
    @Test
    public void listEmpty(){
        List<Task> tasks = new ArrayList<>();

        ArrayList<Task> subset = (ArrayList<Task>) Task.sort(tasks, 6);
        String actual = subset.toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
    /**
     * This tests the removing of an object from a list of the totaltime 
     * is greater then the max allowed time
     */
    @Test
    public void list5Time(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundry", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));

        ArrayList<Task> subset = (ArrayList<Task>) Task.sort(tasks, 5);
        String actual = subset.toString();
        String expected = "[Sweep(1 hour), Mop(2 hour)]";
        assertEquals(expected, actual);
    }
}