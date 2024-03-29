package edu.vaugus.binaryheap;


import edu.vaugus.binaryheap.model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static edu.vaugus.binaryheap.MockUtils.createHeapNode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryHeapTest {

    private final Node priorityTwenty = createHeapNode(20.0);
    private final Node priorityTen = createHeapNode(10.0);
    private final Node priorityFive = createHeapNode(5.0);

    private BinaryHeap heap;

    @Test
    public void testBinaryHeapInitialization() {
        heap = new BinaryHeap(10);

        assertTrue(heap.getIndexMap() != null);
        assertTrue(heap.getPriorityQueue() != null);
        assertArrayEquals(new int[10], heap.getIndexMap());
        Assertions.assertEquals(10, heap.getPriorityQueue().size());
        heap.getPriorityQueue().stream().forEach(node -> assertNull(node));
    }

    @Test
    public void testBubbleDownWorstCase() {
        heap = new BinaryHeap(3);
        setupHeapReverseOrder();

        assertPriorityQueueOrder(2, 1, 0);
        heap.bubbleDown(0);
        assertPriorityQueueOrder(0, 1, 2);
    }
    
    @Test
    public void testBubbleDownBestCase() {
        heap = new BinaryHeap(3);
        setupHeapCorrectOrder();

        assertPriorityQueueOrder(0, 1, 2);
        heap.bubbleDown(0);
        assertPriorityQueueOrder(0, 1, 2);
    }

    @Test
    public void testBubbleDownAverageCase() {
        heap = new BinaryHeap(3);
        setupHeapIncorrectOrder();

        assertPriorityQueueOrder(1, 0, 2);
        heap.bubbleDown(0);
        assertPriorityQueueOrder(0, 1, 2);
    }

    @Test
    public void testBubbleUpBestCase() {
        heap = new BinaryHeap(3);
        setupHeapCorrectOrder();

        assertPriorityQueueOrder(0, 1, 2);
        heap.bubbleUp(0);
        assertPriorityQueueOrder(0, 1, 2);
    }
    
    @Test
    public void testBubbleUpAverageCase() {
        heap = new BinaryHeap(3);
        setupHeapIncorrectOrder();

        assertPriorityQueueOrder(1, 0, 2);
        heap.bubbleDown(0);
        assertPriorityQueueOrder(0, 1, 2);
    }

    @Test
    public void testBubbleUpWorstCase() {
        heap = new BinaryHeap(3);
        setupHeapReverseOrder();

        assertPriorityQueueOrder(2, 1, 0);
        heap.bubbleDown(0);
        assertPriorityQueueOrder(0, 1, 2);
    }

    @Test
    public void testExtractMin() {
        heap = new BinaryHeap(3);

        setupHeapReverseOrder();
        heap.bubbleDown(0);
        Assertions.assertEquals(priorityFive.getPriority(), heap.extractMin().getPriority());
        
        setupHeapIncorrectOrder();
        heap.bubbleDown(0);
        Assertions.assertEquals(priorityFive.getPriority(), heap.extractMin().getPriority());

        setupHeapCorrectOrder();
        heap.bubbleDown(0);
        Assertions.assertEquals(priorityFive.getPriority(), heap.extractMin().getPriority());
    }

    @Test
    public void testDecreaseKey() {
        heap = new BinaryHeap(3);

        setupHeapCorrectOrder();
        Assertions.assertEquals(priorityTen, heap.getPriorityQueue().at(1));

        heap.decreaseKey(1, 2.0);

        Assertions.assertEquals(1, heap.getPriorityQueue().at(0).getIndex());
        Assertions.assertEquals(2.0, heap.getPriorityQueue().at(0).getPriority());
    }

    @Test
    public void testHeapify() {
        heap = new BinaryHeap(3);

        heap.heapify(0);

        Assertions.assertEquals(0, heap.getPriorityQueue().at(0).getIndex());
        Assertions.assertEquals(0.0, heap.getPriorityQueue().at(0).getPriority());
        Assertions.assertEquals(1, heap.getPriorityQueue().at(1).getIndex());
        Assertions.assertEquals(Double.MAX_VALUE, heap.getPriorityQueue().at(1).getPriority());
        Assertions.assertEquals(2, heap.getPriorityQueue().at(2).getIndex());
        Assertions.assertEquals(Double.MAX_VALUE, heap.getPriorityQueue().at(2).getPriority());
    }

    private void assertPriorityQueueOrder(int... order) {
        Assertions.assertEquals(heap.getPriorityQueue().at(order[0]), priorityFive);
        Assertions.assertEquals(heap.getPriorityQueue().at(order[1]), priorityTen);
        Assertions.assertEquals(heap.getPriorityQueue().at(order[2]), priorityTwenty);
    }
    
    private void setupHeapReverseOrder() {
        setupQueueState(2, 1, 0);
    }

    private void setupHeapCorrectOrder() {
        setupQueueState(0, 1, 2);
    }

    private void setupHeapIncorrectOrder() {
        setupQueueState(1, 0, 2);
    }
    
    private void setupQueueState(int... order) {
        priorityFive.setIndex(order[0]);
        priorityTen.setIndex(order[1]);
        priorityTwenty.setIndex(order[2]);

        heap.getIndexMap()[1] = order[1];
        heap.getIndexMap()[2] = order[2];

        heap.getPriorityQueue().insert(order[0], priorityFive);
        heap.getPriorityQueue().insert(order[1], priorityTen);
        heap.getPriorityQueue().insert(order[2], priorityTwenty);
    }
}
