package ary;

//Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
//
//A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
//
//3 is an equilibrium index, because:
//A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
//
//6 is also an equilibrium index, 
//because sum of zero elements is zero, i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0

public class EquiliberiumIndex 
{
    int equilibrium(int arr[], int n) 
    {
        int i, j;
        int leftsum, rightsum;
 
        /* Check for indexes one by one until an equilibrium
           index is found */
        for (i = 0; i < n; ++i) 
        {
            leftsum = 0;  // initialize left sum for current index i
            rightsum = 0; // initialize right sum for current index i
 
            /* get left sum */
            for (j = 0; j < i; j++)
                leftsum += arr[j];
 
            /* get right sum */
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];
 
            /* if leftsum and rightsum are same, then we are done */
            if (leftsum == rightsum)
                return i;
        }
 
        /* return -1 if no equilibrium index is found */
        return -1;
    }
//    1) Initialize leftsum  as 0
//    2) Get the total sum of the array as sum
//    3) Iterate through the array and for each index i, do following.
//        a)  Update sum to get the right sum.  
//               sum = sum - arr[i] 
//           // sum is now right sum
//        b) If leftsum is equal to sum, then return current index. 
//        c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
//    4) return -1 // If we come out of loop without returning then
//                 // there is no equilibrium index
    //Time Complexity: O(n)
    int equilibrium1(int arr[], int n)
    {
        int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
 
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];
 
        for (int i = 0; i < n; ++i)
        {
            sum -= arr[i]; // sum is now right sum for index i
 
            if (leftsum == sum)
                return i;
 
            leftsum += arr[i];
        }
 
        /* If no equilibrium index found, then return 0 */
        return -1;
    }
 
    public static void main(String[] args) 
    {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
    	for(int i=0; i< arr.length; ++i) {
    		System.out.println(i);
    	}
    	
    	EquiliberiumIndex equi = new EquiliberiumIndex();

        int arr_size = arr.length;
        System.out.println("\nOutput: ");
        System.out.println(equi.equilibrium(arr, arr_size));
    }
}