package test;

public class KthMedianSortedArray {

	public static void main(String[] args) {
		int[] ary1 = { 1, 7, 9, 15, 17 };
		int[] ary2 = { 2, 8, 18, 21, 23 };
		int median = findMedian(ary1, ary2);
		System.out.println(median);

	}

	static int findMedian(int[] ary1, int[] ary2) {
		if (ary1.length <= 0 && ary2.length <= 0)
			return -1;
		int i = 0;
		int j = 0;
		int index = -1;
		int count = 0;
		int median = -1;
		boolean flag = false;
		if (ary1.length == 0 && ary2.length > 0) {
			if ((ary2.length % 2) == 0) {
				return ary2[(ary2.length / 2) - 1];
			} else {
				return ary2[ary2.length / 2];
			}

		}

		else if (ary1.length > 0 && ary2.length == 0) {
			if ((ary1.length % 2) == 0) {
				return ary1[(ary1.length / 2) - 1];
			} else {
				return ary1[ary1.length / 2];
			}
		}

		else {
			int len = ary1.length + ary2.length;
			boolean even = true;
			if (len % 2 == 0) {
				index = (len / 2) - 1;
			} else {
				even = false;
				index = len / 2;
			}
			int pre = Integer.MIN_VALUE;
			// use while loop
			while (true) {
				boolean left = true;
				if (ary1[i] <= ary2[j]) {
					i++;
				} else {
					left = false;
					j++;
				}
				if (count == index) {

					if (even) {
						if(pre == Integer.MIN_VALUE) {
							if (left) {
								pre = ary1[i-1];
							} else {
								pre = ary2[j-1];
							}
							index++;
							count++;							
							continue;
						}else {
							if (left) {
								median = ary1[i-1];
							} else {
								median = ary2[j-1];
							}
							median = (median + pre)/2;
						}
					} else {
						flag = true;
						if (left) {
							median = ary1[i-1];
						} else {
							median = ary2[j-1];
						}
					}
					break;
				}
				count++;
			}

		}
		if (!flag) {

			while (i < ary1.length) {
				count++;
				if (count == index) {
					return ary1[i];
				}
				i++;
			}
			while (j < ary2.length) {
				count++;
				if (count == index) {
					return ary2[j];
				}
				j++;
			}
		}

		return median;

	}
}