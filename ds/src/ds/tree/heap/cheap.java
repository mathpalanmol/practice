package ds.tree.heap;

public class cheap {

	static int[] ary = { 1, 7, 3, 4, 3, 6, 2, 9, 10 };

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
