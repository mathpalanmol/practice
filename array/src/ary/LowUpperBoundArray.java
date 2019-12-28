package ary;


import java.util.Arrays;

//Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such
// that sorting this subarray makes the whole array sorted.

//Examples:
//1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be
// able to find that the subarray lies between the indexes 3 and 8.

//2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find
// that the subarray lies between the indexes 2 and 5.

public class LowUpperBoundArray {

    public static void main(String[] args) {
         int[] ary = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
       // int[] ary = {0, 1, 15, 25, 6, 7, 30, 40, 50};
      //  int[] ary = {10, 20, 25, 35, 12, 11, 50, 60};
        //int[] ary = { 1, 2, 3, 4, 5 };
        Node node = calculate(ary);
        //   Node node1 = compareSolution(ary);
        System.out.println("low: " + node.low + " high: " + node.high);
         //  System.out.println("low: " + node1.low + " high: " + node1.high);
        MinMax execute = execute(ary);
        System.out.println("lowIndex: " + execute.getMin() + " highIndex: " + execute.getMax());
    }

    // 1. iterate through entire array and check if it's sorted or not if not take
    // index i. In above example it's i=3, value 25 is the starting point. i=3 as low and i=4 as
    // high
    // 2. initialize c - current element with unsorted element i+1;
    // 3. for every current element check if it's greater than prev ones. if not
    // update the lower and higher values.
    // 4. increment c at the end. the whole idea is to move one time towards right
    // and check the previous if:
    // current < previous means current is right now and if prev index < low it is
    // eligible for low as well.
    private static Node calculate(int[] ary) {
        int i = 0;
        Node node = new Node(-1, -1);
        for (; i < ary.length - 1; i++) {
            if (ary[i + 1] >= ary[i])
                continue;
            else {
                break;
            }

        }
        if (i == ary.length - 1)//sorted array case
            return node;

        node.low = i;
        node.high = i + 1;
        int c = node.high;
        while (c != ary.length - 1) {
            int m = c - 2; // c-1 is always greater than high. so we start with  c-2

            while (m >= 0) {
                if (ary[c] < ary[m]) {
                    node.high = c;  // it should be inside
                    if (m < node.low) {
                        node.low = m;
                    }
                }
                m--;
            }

            c++;
        }

        return node;
    }

    //copy array and compare
    private static Node compareSolution(int[] ary) {
        Node node = new Node(-1, -1);

        int[] copyAry = Arrays.copyOf(ary, ary.length);
        System.out.println("Orignal Array: " + Arrays.toString(copyAry));
        Arrays.sort(ary);
        System.out.println("Sorted Array : " + Arrays.toString(ary));
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] != copyAry[i]) {
                node.low = i;
                break;
            }
        }
        for (int i = ary.length - 1; i >= 0; i--) {
            if (ary[i] != copyAry[i]) {
                node.high = i;
                break;
            }
        }
        return node;
    }

    static MinMax execute(int[] ary) {
        MinMax minMaxIndex = getMinMax(ary);
        MinMaxVal minMaxVal = findMinMaxVal(ary, minMaxIndex);

        int min = finalizeMin(minMaxIndex.getMin(), ary, minMaxVal.minVal);
        int max = finalizeMax(minMaxIndex.getMax(), ary, minMaxVal.maxVal);
        return new MinMax(min, max);
    }

    private static MinMaxVal findMinMaxVal(int[] ary, final MinMax minMaxIndex) {
        int minVal = ary[minMaxIndex.getMin()];
        int maxVal = ary[minMaxIndex.getMax()];
        for (int i = minMaxIndex.getMin(); i <= minMaxIndex.getMax(); i++) {
            if (ary[i] < minVal)
                minVal = ary[i];
            if (ary[i] > maxVal)
                maxVal = ary[i];
        }
        return new MinMaxVal(minVal, maxVal);
    }

    static private int finalizeMin(final int minIndex, final int[] ary, final int minVal) {
        int min = -1;
        for (int i = 0; i < minIndex; i++) {
            if (ary[i] > minVal){
                min = i;
                break;
            }
        }
        return min;
    }

    static private int finalizeMax(final int maxIndex, final int[] ary, final int maxVal) {
        int max = maxIndex;
        for (int i = ary.length - 1; i > maxIndex; i--) {
            if (ary[i] < maxVal){
                max = i;
                break;
            }
        }
        return max;
    }

    static private MinMax getMinMax(final int[] ary) {
        int min = -1;
        int max = ary.length - 1;
        for (int i = 0; i < ary.length - 1; i++) {
            if (ary[i] > ary[i + 1]) {
                min = i+1;
                break;
            }
        }
        if (min == -1)
            return new MinMax(-1, -1);
        for (int j = ary.length - 1; j >= 0; j--) {
            if (ary[j] < ary[j - 1]) {
                max = j-1;
                break;
            }
        }
//        int max1 = max;
//        for(int i = min; i<=max1; i++){
//        	if(ary[i] < ary[min])
//        		min = i;
//        	if(ary[i] > ary[max])
//        		max = i;
//		}
        return new MinMax(min, max);
    }

    static class MinMaxVal {
        int minVal;
        int maxVal;

        private MinMaxVal(final int minVal, final int maxVal) {
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    static class Node {
        int low;
        int high;

        public Node(int low, int high) {
            super();
            this.low = low;
            this.high = high;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "low=" + low +
                    ", high=" + high +
                    '}';
        }
    }

    static class MinMax {
        int min;
        int max;

        private MinMax(final int min, final int max) {
            this.min = min;
            this.max = max;
        }

        private int getMin() {
            return min;
        }

        private void setMin(final int min) {
            this.min = min;
        }

        private int getMax() {
            return max;
        }

        private void setMax(final int max) {
            this.max = max;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

}
