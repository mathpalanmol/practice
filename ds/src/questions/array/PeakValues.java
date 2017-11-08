package questions.array;

public class PeakValues {

	static void peak(int[] ary, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		int next = mid + 1;
		int pre = mid - 1;
		if (high - low == 1)
			pre = low;
		if (ary[mid] >= ary[pre] && ary[mid] >= ary[next]) {
			System.out.print(ary[mid] + ", ");
		}
		if (ary[mid] >= ary[pre] && ary[next] >= ary[mid])
			peak(ary, mid + 1, high);

		peak(ary, low, mid - 1);

	}

	public static int peakElement1(int[] ary) {
		for (int i = 1; i < ary.length - 1; i++) {
            if((ary[i-1]<ary[i]) && (ary[i] > ary[i+1]))
            	return ary[i];
		}
		return -1;
		

	}

	public static void main(String[] args) {
		PeakValues ref = new PeakValues();
		int[] ary = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25, 100 };
		System.out.println(getPeakElement(ary));
		peak(ary,0,ary.length-1);
		System.out.println(peakElement1(ary));

	}

	public static Integer getPeakElement(int[] array) {

		if (array == null || array.length == 0) {
			return null;
		}

		int n = array.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == n - 1 || array[mid] >= array[mid + 1])) {
				System.out.println("peak Value: " + array[mid]);
				return array[mid]; // array[mid] is peak element
			} else if (mid > 0 && array[mid - 1] > array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}
}
