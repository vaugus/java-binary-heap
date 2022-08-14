package edu.algorithm.design.binaryheap;

import edu.algorithm.design.binaryheap.model.Node;
import edu.algorithm.design.binaryheap.model.PriorityQueue;

public abstract class MockUtils {

    public static Node createHeapNode(int index, double priority) {
        Node heapNode = new Node();
        heapNode.setPriority(priority);
        heapNode.setIndex(index);
        return heapNode;
    }

    public static Node createHeapNode(double priority) {
        return new Node.Builder()
            .withPriority(priority)
            .build();
    }

    public static PriorityQueue createPriorityQueue(Node... heapNodes) {
        PriorityQueue queue = new PriorityQueue(heapNodes.length);
        for (int i = 0; i < heapNodes.length; i++) {
            queue.insert(i, heapNodes[i]);
        }

        return queue;
    }
}
