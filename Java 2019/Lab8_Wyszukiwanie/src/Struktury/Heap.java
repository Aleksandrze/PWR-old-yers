package Struktury;

public class Heap {
	private final static int DEFAULT_SIZE = 15;
	private int[] heap;
	private int size;
	private int min, max;

	public Heap(int initSize) {
		this.heap = new int[initSize];
		size = 0;
		setRange();
	}

	public Heap() {
		this(DEFAULT_SIZE);
	}

	public void enqueue(int element) {
		if (size >= max)
			resize(1);
		heap[size++] = element;
		 heapify();
	}

	public int dequeue() {
		return this.remove(0);
		// usunience kopca powino buc
	}

	public int remove(int index) {
		if (size <= min)
			resize(-1);
		int output = heap[index];
		for (int i = index; i < size - 1; i++)
			heap[i] = heap[i + 1];
		size--;
		heapify();
		return output;
	}

	public void remove() {
		this.remove(size - 1);
	}

	private void swap(int left, int right) {
		int temp = heap[left];
		heap[left] = heap[right];
		heap[right] = temp;
	}

	private void check(int parent) {
		int leftChild = parent * 2 + 1;
		int rightChild = parent * 2 + 2;
		int oldest = parent;

		if (rightChild < size && heap[leftChild] > heap[rightChild])
			swap(leftChild, rightChild);

		if (leftChild < size && heap[leftChild] < heap[parent])
			oldest = leftChild;

		if (rightChild < size)
			if (heap[rightChild] < heap[oldest])
				oldest = rightChild;

		if (oldest != parent) {
			swap(parent, oldest);
			check(oldest);
		}
	}

	private void heapify() {
		for (int parent = size / 2 - 1; parent >= 0; parent--)
			check(parent);
	}

	private void resize(int arg) {
		if (arg == -1) {
			int[] tempHeap = new int[min];
			for (int i = 0; i < size; i++)
				tempHeap[i] = heap[i];
			heap = tempHeap;
		} else if (arg == 1) {
			int[] tempHeap = new int[max];
			for (int i = 0; i < size; i++)
				tempHeap[i] = heap[i];
			heap = tempHeap;
		}

		setRange();
	}

	private void setRange() {
		int row = (int) (Math.log(heap.length + 1) / Math.log(2));
		min = (int) (Math.pow(2, row - 1) - 1);
		max = (int) (Math.pow(2, row + 1) - 1);
	}

	public boolean empty() {
		return size == 0;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < size; i++) {
			output += heap[i] + " ";
		}
		output += "rozmiar = " + size;
		return output;
	}

	public void changePriority(int index, int value) {
		heap[index] = value;
		 heapify();
	}

}
