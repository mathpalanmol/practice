package com.practice.prepare;

public class SearchRotatedSortedArray {

    /**
     * Returns the index of target in a rotated sorted array with distinct values,
     * or -1 if not found.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray solver = new SearchRotatedSortedArray();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(solver.search(nums, 0)); // 4
        System.out.println(solver.search(nums, 3)); // -1
    }
}
