package questions.array;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ary = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean output = binarySearch(ary, 0, ary.length - 1, 3);
        System.out.println(output);
	}

	private static boolean binarySearch(int[] ary, int l, int h, int key) {
		if (l > h)
			return false;

		int mid = (l + h) / 2;
		
		if (ary[mid] == key) {
			System.out.println(ary[mid]);
			System.out.println("Found");
			return true;
		}
		System.out.println(ary[mid]);
        
		if(key<ary[mid])
		return binarySearch(ary, l, mid - 1, key);
		else
		return binarySearch(ary, mid + 1, h, key);
		
		
	}
	
	

}
