package br.imd.compressor.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class MinHeap{

	    public Node[] nodes;
	    private int size;
	    private int capacity;

	    public MinHeap() {
	        this(10);
	    }
	    public MinHeap(int capacity) {
	        nodes = new Node[capacity];
	        this.size = 0;
	        this.capacity = capacity;
	    }
	    public void addNode(int letter) {
	        addNode(new Node(letter));
	    }

	    public void addNode(Node letter) {
	        this.ensureCapacity();
	        this.nodes[getSize()] = letter;
	        heapifyUp(getSize());
	        size++;
	    }

	    private void heapifyUp(int index) {
	        if (!hasParent(index)) {
	            return;
	        }
	        int parentIndex = getParentIndex(index);

	        Node node = nodes[index];
	        Node pai = nodes[parentIndex];

	        if (node.getCount() > pai.getCount()) {
	            nodes[index] = pai;
	            nodes[parentIndex] = node;
	            heapifyUp(parentIndex);
	        }
	    }

	    private boolean hasParent(int index) {
	        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
	    }

	    private int getParentIndex(int index) {
	        return (int) Math.floor((index - 1) / 2);
	    }

	    private void ensureCapacity() {
	        if (getSize() == capacity) {
	            this.nodes = (Node[]) Arrays.copyOf(this.nodes, getSize() * 2);
	            capacity = getSize() * 2;
	        }
	    }

	    public int getSize() {
	        return size;
	    }

	    public Node peek() {
	        if (getSize() == 0) {
	            return null;
	        }
	        return nodes[0];
	    }

	    public void remove() {
	        nodes[0] = nodes[getSize() - 1];
	        nodes[getSize() - 1] = null;
	        size--;
	        heapifyDown(0);
	    }

	    public void remove(int index) {
	        pessoas[index].unregister(this);
	        pessoas[index] = pessoas[getSize() - 1];
	        pessoas[getSize() - 1] = null;
	        size--;
	        heapifyDown(index);
	    }

	    private void heapifyDown(int index) {
	        int leftChild = index * 2 + 1;
	        int rightChild = index * 2 + 2;
	        int childIndex = -1;
	        if (leftChild < getSize()) {
	            childIndex = leftChild;
	        }
	        if (childIndex < 0) {
	            return;
	        }
	        if (rightChild < getSize()) {
	            if (pessoas[rightChild].getIdade() > pessoas[leftChild].getIdade()) {
	                childIndex = rightChild;
	            }
	        }
	        if (pessoas[index].getIdade() < pessoas[childIndex].getIdade()) {
	            Pessoa tmp = pessoas[index];
	            pessoas[index] = pessoas[childIndex];
	            pessoas[childIndex] = tmp;
	            heapifyDown(childIndex);
	        }
	    }


}


