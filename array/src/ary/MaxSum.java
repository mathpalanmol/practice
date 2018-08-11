package ary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { -1, -2, 1, 3 };
		int[] arr1 = {4,1,2,3,4};
		System.out.println(maximumSum(arr));
		System.out.println(maximumSum(arr1));

	}
	


	static long maximumSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i + 1]){
				if(arr[i]>max)
					max = arr[i];
				continue;
				}
			
			int count = 0;
			while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
				count = count + arr[i];
				i++;
			}
			if(i == arr.length-1 && arr[i] > arr[i-1]){
				count = count + arr[i];
			}
				
			if (count > max)
				max = count;
			

		}
		return max;

	}
	
 static void customSort(int[] arr) {
  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  for(int i=0; i<arr.length; i++){
  	if(map.containsKey(i))
  		continue;
  	int count = 0;
  	for(int j=i+1; j< arr.length; j++){
  		if(arr[i] == arr[j])
  			count++;
  	}
  	map.put(i, count);
  }
  List<Integer> sortedKeys=new ArrayList(map.values());
  Collections.sort(sortedKeys);
  for(int key : sortedKeys)
  	System.out.println(key);

  }
}
