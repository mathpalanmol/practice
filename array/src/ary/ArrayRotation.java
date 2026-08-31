package ary;

// O(log n) — binary search variant to find rotation pivot
// Example: {4, 5, 1, 2, 3} → pivot index = 2
public class ArrayRotation {
    public static void main(String[] args) {
        ArrayRotation obj = new ArrayRotation();
        int[] ary = { 4, 5, 6, 7, 0, 1, 2 };
        // int[] ary = { 2, 3, 1 };
        // int[] ary = { 1, 2, 3, 4, 5 };

        System.out.println("Rotated Index is: " + obj.findRotateIndex(ary));
        System.out.println("Search 0: " + obj.searchInRotatedArray(ary, 0));
        System.out.println("Search 3: " + obj.searchInRotatedArray(ary, 3));
    }

    int findRotateIndex(int[] ary) {
        int low = 0;
        int high = ary.length - 1;

        if (ary[low] < ary[high]) {
            return -1; // array is not rotated
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pre = (mid - 1 + ary.length) % ary.length;
            int next = (mid + 1) % ary.length;

            if (ary[mid] < ary[pre] && ary[mid] < ary[next]) {
                return mid;
            }

            if (ary[low] <= ary[mid]) {
                low = mid + 1; // pivot in right half
            } else {
                high = mid - 1; // pivot in left half
            }
        }

        return -1;
    }

    /**
     * Returns index of target in a rotated sorted array, or -1 if not found.
     */
    int searchInRotatedArray(int[] ary, int target) {
        int left = 0;
        int right = ary.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ary[mid] == target) {
                return mid;
            }

            if (ary[left] <= ary[mid]) {
                if (ary[left] <= target && target < ary[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (ary[mid] < target && target <= ary[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
