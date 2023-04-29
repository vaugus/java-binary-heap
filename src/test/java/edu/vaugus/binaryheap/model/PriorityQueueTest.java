package edu.vaugus.binaryheap.model;

import org.junit.jupiter.api.Test;

import static edu.vaugus.binaryheap.MockUtils.createHeapNode;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    private Node lowerPriority = createHeapNode(0,10.0);
    private Node samePriority = createHeapNode(1, 10.0);
    private Node higherPriority = createHeapNode(2, 20.0);

    @Test
    public void testQueueInitialization() {
        PriorityQueue queue = new PriorityQueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void testInsertNodesIntoQueue() {
        PriorityQueue queue = new PriorityQueue(3);
        queue.insert(0, lowerPriority);
        queue.insert(1, samePriority);
        queue.insert(2, higherPriority);

        assertEquals(lowerPriority, queue.at(0));
        assertEquals(samePriority, queue.at(1));
        assertEquals(higherPriority, queue.at(2));
    }

    @Test
    public void testHasLowerPriority() {
        PriorityQueue queue = new PriorityQueue(3);
        queue.insert(0, lowerPriority);
        queue.insert(1, samePriority);
        queue.insert(2, higherPriority);

        assertTrue(queue.hasLowerPriority(0, 2));
        assertFalse(queue.hasLowerPriority(0, 1));
        assertTrue(queue.hasLowerPriority(1, 2));
    }
}
