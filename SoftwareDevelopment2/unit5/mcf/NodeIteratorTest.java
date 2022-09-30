package mcf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class NodeIteratorTest {
    @Test
    public void createNull() {
        // setup
        Node<String> node = null;

        // invoke
        NodeIterator<String> iter = new NodeIterator<>(node);

        // analyze
        assertFalse(iter.hasNext());
    }

    @Test
    public void createNonNull() {
        // setup
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        a.setNext(b);

        // invoke
        NodeIterator<String> iter = new NodeIterator<>(a);

        // analyze
        assertTrue(iter.hasNext());
        assertEquals("a", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("b", iter.next());
        assertFalse(iter.hasNext());
    }
}
