package ary;


// Finding three elements in an array whose sum is closest to a given number
// Brute force O(n3); Take three loops i, j=i+1, k = j+1 
public class TripletSumToClosest {

	public static void main(String[] args) {
//		int[] ary = { -1, 0, 1, 2, 3, 5, -4, 6 };
		int[] ary = { -1, 0, 1, 2, 3, 5, -4, 10 };
		int sum = 4;
		int[] triplet = findTriplet(ary, sum); 
		for(int index : triplet) {
			System.out.print(ary[index] + " ");
		}

	}


   //O(n2)
	private static int[] findTriplet(int[] ary, int sum) {
		int[] indexAry = new int[3];
        int min = Integer.MAX_VALUE;
		for (int i = 0; i < ary.length-2; i++) { // iterate one by one; no need to process last 2 in this loop as we are looking for triplet
			int total = sum;
			int m = i+1; // second to i
			int n = ary.length-1; // last
			total = total - ary[i];
			while (n > m) { // we need triplet so no equals
				int diff = Math.abs(total - (ary[m] + ary[n]));
				System.out.println("Min value: " + min);
				if(diff < min) {
					min = diff;
					indexAry[0] = i; // for now it will return one triplet but we can return list of objects to return multiple triplet
					indexAry[1] = m;
					indexAry[2] = n;
					if(diff == 0)
						return indexAry;
				}
				if(diff>0) // Imp if diff is greater than 0 that means there a further chance to increase operand
				m++;
				else
				n--; // less than zero; decrease the operand
			}

		}
		return indexAry;
	}

}
