package edu.vaugus.binaryheap.model;

import java.util.Arrays;
import java.util.stream.Stream;

public class PriorityQueue {

    private final Node[] queue;

    public PriorityQueue(int size) {
        this.queue = new Node[size];
    }

    public void insert(int slot, Node heapNode) {
        queue[slot] = heapNode;
    }

    public Node at(int index) {
        return queue[index];
    }

    public int size() {
        return queue.length;
    }

    public void swap(int source, int target) {
        Node temporaryNode = queue[source];
        queue[source] = queue[target];
        queue[target] = temporaryNode;
    }

    public Stream<Node> stream() {
        return Arrays.stream(queue);
    }

    public boolean hasLowerPriority(int a, int b) {
        return queue[a].compareTo(queue[b]) == -1;
    }

    @Override
    public String toString() {
        return "PriorityQueue [queue=" + Arrays.toString(queue) + "]";
    }
}
