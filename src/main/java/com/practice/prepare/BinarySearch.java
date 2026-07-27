package com.practice.prepare;

public class BinarySearch {

    /**
     * Returns the index of target in a sorted array, or -1 if not found.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solver = new BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(solver.search(nums, 9));  // 4
        System.out.println(solver.search(nums, 2));  // -1
    }
}
