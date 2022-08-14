package edu.algorithm.design.binaryheap.model;

import org.junit.jupiter.api.Test;

import edu.algorithm.design.binaryheap.model.Node;

import static edu.algorithm.design.binaryheap.MockUtils.createHeapNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    @Test
    public void testHeapNodeCompareTo() {
        Node lowerPriority = createHeapNode(0,10.0);
        Node samePriority = createHeapNode(1, 10.0);
        Node higherPriority = createHeapNode(2, 20.0);

        assertEquals(-1, lowerPriority.compareTo(higherPriority));
        assertEquals(1, higherPriority.compareTo(lowerPriority));
        assertEquals(0, samePriority.compareTo(lowerPriority));
    }
}
    