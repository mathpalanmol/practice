package questions.array;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ary = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		boolean output = binarySearch(ary, 0, ary.length - 1, 3);
        System.out.println(output);
	}

	private static boolean binarySearch(int[] ary, int l, int h, int key) {
		System.out.println("low: " + l + " high " + h);
		if (l > h) 
			return false;
	//	System.out.println("low: " + l + " high " + h);

		int mid = (l + h) / 2;
//		System.out.println("low: " + l + " mid " + mid + " high " + h);
		
		if (ary[mid] == key) {
//			System.out.println(ary[mid]);
//			System.out.println("Found");
			return true;
		}
	//	System.out.println(ary[mid]);
        
		if(key<ary[mid])
		return binarySearch(ary, l, mid - 1, key);
		else
		return binarySearch(ary, mid + 1, h, key);
		
		
	}
	
	

}
