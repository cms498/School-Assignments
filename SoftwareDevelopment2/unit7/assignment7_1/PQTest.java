package assignment7_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PQTest {
    @Test
    public void HeapInitilization(){
        //setup
        HeapPQ<Integer> queue = new HeapPQ<>();
        int expected = 0;
        //invoke
        int actual = queue.size();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void HeapEnqueue(){
        //setup
        HeapPQ<Integer> queue = new HeapPQ<>();
        int expected = 1;
        //invoke
        queue.enqueue(5);
        int actual = queue.size();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void HeapEnqueueAndDequeue(){
        //setup
        HeapPQ<Integer> queue = new HeapPQ<>();
        int expected = 1;
        //invoke
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(1);
        int actual = queue.dequeue();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void HeapEnqueueAndDequeueMultiple(){
        //setup
        HeapPQ<Integer> queue = new HeapPQ<>();
        int expected = 3;
        //invoke
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(1);
        queue.dequeue();
        int actual = queue.dequeue();
        //analyze
        assertEquals(expected, actual);
    }   
    @Test
    public void ListInitilization(){
        //setup
        ListPQ<Integer> queue = new ListPQ<>();
        int expected = 0;
        //invoke
        int actual = queue.size();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void ListEnqueue(){
        //setup
        ListPQ<Integer> queue = new ListPQ<>();
        int expected = 1;
        //invoke
        queue.enqueue(5);
        int actual = queue.size();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void ListEnqueueAndDequeue(){
        //setup
        ListPQ<Integer> queue = new ListPQ<>();
        int expected = 1;
        //invoke
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(1);
        int actual = queue.dequeue();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void ListEnqueueAndDequeueMultiple(){
        //setup
        ListPQ<Integer> queue = new ListPQ<>();
        int expected = 4;
        //invoke
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        int actual = queue.dequeue();
        //analyze
        assertEquals(expected, actual);
    }
}