package edu.vaugus.binaryheap;

import edu.vaugus.binaryheap.model.Node;
import edu.vaugus.binaryheap.model.PriorityQueue;

public abstract class MockUtils {

    public static Node createHeapNode(int index, double priority) {
        return new Node.Builder()
            .index(index)
            .priority(priority)
            .build();
    }

    public static Node createHeapNode(double priority) {
        return new Node.Builder().priority(priority).build();
    }

    public static PriorityQueue createPriorityQueue(Node... heapNodes) {
        PriorityQueue queue = new PriorityQueue(heapNodes.length);
        for (int i = 0; i < heapNodes.length; i++) {
            queue.insert(i, heapNodes[i]);
        }

        return queue;
    }
}
