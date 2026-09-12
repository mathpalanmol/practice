package array.twopointers;

import java.util.Arrays;

/**
 * Sort Binary Array (0s and 1s) — Dutch National Flag (two colors)
 *
 * <p>Given an array containing only {@code 0} and {@code 1}, sort in-place so all 0s precede
 * all 1s. Classic two-pointer variant of Sort Colors (LeetCode #75) with two values.
 *
 * <p>Constraints: in-place; O(n) time, O(1) extra space.
 *
 * <pre>
 * Input:  [0, 1, 1, 0, 1, 0, 0, 1]
 * Step:   swap misplaced 1/0 pairs inward until left meets right
 * Output: [0, 0, 0, 0, 1, 1, 1, 1]
 * </pre>
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code left = 0}, {@code right = n - 1}.</li>
 *   <li>While {@code left &lt; right}: advance {@code left} while {@code a[left] == 0}.</li>
 *   <li>Advance {@code right} while {@code a[right] == 1}.</li>
 *   <li>If still {@code left &lt; right}, swap {@code a[left]} and {@code a[right]} (1 on left, 0 on right), then {@code left++}, {@code right--}.</li>
 * </ol>
 * <p>Invariant: {@code [0..left-1]} all 0s; {@code [right+1..n-1]} all 1s. Time: O(n), Space: O(1)
 */
public class SortZeroOne {

    /** Dutch National Flag (two colors) — see class {@code Algorithm} section. */
    public static void sort01(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            // skip 0s already in the correct (left) zone
            while (left < right && a[left] == 0) {
                left++;
            }
            // skip 1s already in the correct (right) zone
            while (left < right && a[right] == 1) {
                right--;
            }
            // now left points at a 1 and right at a 0 (if they haven't met)
            if (left < right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 0, 1, 0, 0, 1};
        System.out.println("Before: " + Arrays.toString(a));
        sort01(a);
        System.out.println("After:  " + Arrays.toString(a));

        int[] b = {1, 1, 1, 0, 0};
        System.out.println("Before: " + Arrays.toString(b));
        sort01(b);
        System.out.println("After:  " + Arrays.toString(b));

        int[] c = {0, 0, 1, 1};
        System.out.println("Before: " + Arrays.toString(c));
        sort01(c);
        System.out.println("After:  " + Arrays.toString(c));
    }
}
