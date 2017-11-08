package sort;
/*
 * Insertion sort: in-place and stable
 * in-place means sorting can be done without auxiliary memory or with some additional variable
 * stable: maintains internal order
 * It is useful to sort small data sets and has advantage over selection sort if the data set is partially or completely sorted
 * Complexity O(n2)
 * */
public class cinsertionsort {
	static int[] ary = { 1, 7, 3, 4, 3, 6, 2, 9, 10 };

	public static void main(String[] args) {
		display();
		sort();
		display();

	}

	private static void display() {
		for (int value : ary)
			System.out.print(value + " ");
		System.out.println();
	}

	private static void swap(int i, int j) {
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;

	}

	private static void sort() {
		for (int i = 1; i < ary.length; i++) {
			int temp = i;
			int j = i - 1;
			while (j >= 0) {
				if (ary[temp] < ary[j]) {
					swap(temp, j);
					temp = j;
				} else
					break;
				j--;
			}
		}

	}

}
