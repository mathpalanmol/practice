package ds.tree.heap;

public class cheap {

	static int[] ary = { 1, 7, 3, 4, 3, 6, 2, 9, 10 };
	

// Introduction to Priority Queues using Binary Heaps
// Convert Max Heap to Min Heap in linear time  -- ?s
// Find K’th largest element in an array
// Sort a K-Sorted Array
// Merge M sorted lists of variable length
// Find K’th smallest element in an array
	
	
// Find smallest range with at-least one element from each of the given lists
// Merge M sorted lists each containing N elements
// External merge sort
// Huffman Coding
// Find first k maximum occurring words in given set of strings
// Find first k non-repeating characters in a string in single traversal

	int getParent(int index) {	
		if (index <= 0 || index >= ary.length)
			return -1;
		int pIndex = (index - 1) / 2;
		return pIndex;
	}

	int getlChild(int index) {
		if (index < 0 || index >= ary.length)
			return -1;
		int lIndex = (2 * index) + 1;
		if (lIndex >= ary.length)
			return -1;
		return lIndex;
	}

	int getrChild(int index) {
		if (index < 0 || index >= ary.length)
			return -1;
		int rIndex = (2 * index) + 2;
		if (rIndex >= ary.length)
			return -1;
		return rIndex;
	}
   // Add heapify up
	void processMax(int index) {
		// int pIndex = getParent(index);
		while (index >= 0) {
			int pIndex = getParent(index);
			if (pIndex == -1)
				break;
			if (ary[index] > ary[pIndex]) {
				swap(index, pIndex);
			} else
				break;
			index = pIndex;
			display();
		}
	}
   // Heapify up
	void processMin(int index) {
		// int pIndex = getParent(index);
		while (index >= 0) {
			int pIndex = getParent(index);
			if (pIndex == -1)
				break;
			if (ary[index] < ary[pIndex]) {
				swap(index, pIndex);
			} else
				break;
			index = pIndex;
			display();
		}
	}

	void buildMaxHeap() {
		for (int i = 0; i < ary.length; i++) {
			processMax(i);
		}
	}

	void buildMinHeap() {
		for (int i = 0; i < ary.length; i++) {
			processMin(i);
		}
	}

	private void swap(int max, int pIndex) {
		int temp = ary[max];
		ary[max] = ary[pIndex];
		ary[pIndex] = temp;
	}

	static void display() {
		for (int value : ary)
			System.out.print(value + " ");
		System.out.println("\n****************");
	}

	public static void main(String[] args) {
		cheap obj = new cheap();
		display();
		obj.buildMinHeap();
		display();

	}

}
