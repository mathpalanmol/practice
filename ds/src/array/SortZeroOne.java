package array;

import java.util.Arrays;

/**
 * Sort an array of 0s and 1s (binary array).
 *
 * <p>Dutch National Flag idea with two colors only — one pass, O(n) time, O(1) extra space.
 *
 * <pre>
 * Input:  [0, 1, 1, 0, 1, 0, 0, 1]
 * Output: [0, 0, 0, 0, 1, 1, 1, 1]
 * </pre>
 *
 * <p>Pointers:
 * <ul>
 *   <li>{@code left} — move until we find a 1 (wrong on the left)</li>
 *   <li>{@code right} — move until we find a 0 (wrong on the right)</li>
 * </ul>
 * Then swap; repeat until left and right meet.
 */
public class SortZeroOne {

    /**
     * Dutch National Flag (two colors) — one pass.
     *
     * <p>Algorithm:
     * <ol>
     *   <li>Advance {@code left} while {@code a[left] == 0}</li>
     *   <li>Advance {@code right} while {@code a[right] == 1}</li>
     *   <li>If still {@code left < right}, swap (left has 1, right has 0)</li>
     * </ol>
     *
     * <p>Invariant:
     * <pre>
     *   [0 .. left-1]    → all 0s
     *   [right+1 .. n-1] → all 1s
     * </pre>
     */
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
