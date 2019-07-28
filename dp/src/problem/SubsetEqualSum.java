package problem;

//note: for all positive integers
//arr[] = {1, 5, 11, 5}
//Output: true 
//The array can be partitioned as {1, 5, 5} and {11}
//
//arr[] = {1, 5, 3}
//Output: false 
//The array cannot be partitioned into equal sum sets.

public class SubsetEqualSum {

	boolean isSubsetSum(int[] ary) {
		int sum = 0;
		for (int val : ary)
			sum += val;
		if(sum % 2 != 0)
			return false;
		return isSubsetSum(ary, 0, 0, sum / 2);
	}

	private boolean isSubsetSum(int[] ary, int index, int sum, int total) {
		if (sum == total)
			return true;
		if (sum > total || index == ary.length)
			return false;
		boolean include = isSubsetSum(ary, index + 1, sum + ary[index], total);
		if (include)
			return true;
		boolean exclude = isSubsetSum(ary, index + 1, sum, total);
		if (exclude)
			return true;
		return false;
	}

	public static void main(String[] args) {
		SubsetEqualSum obj = new SubsetEqualSum();
		int[] ary = { 1, 2, 1 ,2};
		System.out.print(obj.isSubsetSum(ary));
	}
}
