package edu.vaugus.binaryheap.model;

public class Node implements Comparable<Node> {
    private int index;
    private double priority;

    public Node index(int index) {
        this.index = index;
        return this;
    }

    public Node priority(double priority) {
        this.priority = priority;
        return this;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "HeapNode {index = " + index + ", priority = " + priority + "}";
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int compareTo(Node anotherHeapNode) {
        if (this.priority == anotherHeapNode.priority) return 0;
        return this.priority > anotherHeapNode.priority ? 1 : -1;
    }
}
