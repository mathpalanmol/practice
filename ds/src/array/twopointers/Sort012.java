package array.twopointers;

import java.util.Arrays;

/**
 * Sort Colors / Dutch National Flag (LeetCode #75)
 *
 * <p>Given an array with values {@code 0}, {@code 1}, and {@code 2} only, sort it in-place
 * in ascending order in one pass. Same as sorting an array of 0s, 1s, and 2s.
 *
 * <p>Constraints: {@code n == nums.length}, {@code 1 <= n <= 300}; each element is 0, 1, or 2.
 *
 * <pre>
 * Input:  [0, 1, 2, 0, 1, 2, 1, 0]
 * Output: [0, 0, 0, 1, 1, 1, 2, 2]
 * </pre>
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code low = 0} (next slot for 0), {@code mid = 0} (current), {@code high = n - 1} (next slot for 2).</li>
 *   <li>While {@code mid &lt;= high} (not {@code mid &lt; high} — one unknown may remain at {@code mid == high}):</li>
 *   <li>If {@code a[mid] == 0}: swap {@code a[low]} and {@code a[mid]}, then {@code low++}, {@code mid++}.</li>
 *   <li>If {@code a[mid] == 1}: {@code mid++} only.</li>
 *   <li>If {@code a[mid] == 2}: swap {@code a[mid]} and {@code a[high]}, then {@code high--} (do not {@code mid++} — swapped-in value unprocessed).</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <h2>Pointer invariant</h2>
 *
 * <pre>
 *   low  — boundary of 0s (next place for a 0)
 *   mid  — current element being inspected
 *   high — boundary of 2s (next place for a 2)
 *
 * Invariant maintained throughout:
 *   [0 .. low-1]     → all 0s
 *   [low .. mid-1]   → all 1s
 *   [mid .. high]    → unknown (still to process)
 *   [high+1 .. n-1]  → all 2s
 * </pre>
 *
 * <h2>Why {@code mid <= high} (not {@code mid < high})?</h2>
 *
 * <p>{@code [mid .. high]} is the unknown region. When {@code mid == high},
 * <em>one</em> element is still unknown and must be processed. Stopping at
 * {@code mid < high} leaves that element unchecked.
 *
 * <pre>
 * Counterexample: [1, 0]
 *
 *   start: low=0, mid=0, high=1
 *   a[mid]==1 → mid++  →  mid=1, high=1
 *
 *   if (mid &lt; high)  → STOP  → array stays [1, 0]  ✗ wrong
 *   if (mid &lt;= high) → process a[1]==0 → swap with low → [0, 1] ✓
 *
 * Another: [2, 0, 1] with mid &lt; high can stop at [1, 0, 2] ✗
 * </pre>
 */
public class Sort012 {

    /**
     * Dutch National Flag — sort 0, 1, 2 in one pass.
     */
    public static void sort012(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int low = 0;                 // next index for 0
        int mid = 0;                 // current index to inspect
        int high = a.length - 1;     // next index for 2

        // Must be mid <= high (not mid < high):
        // when mid == high, one unknown element remains — see class javadoc example [1, 0].
        while (mid <= high) {
            if (a[mid] == 0) {
                // 0 belongs in the left zone — swap into low, expand both low and mid
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                // 1 belongs in the middle — leave it, move mid forward
                mid++;
            } else {
                // a[mid] == 2 — belongs in the right zone
                // swap with high, shrink high; do NOT mid++ (new a[mid] not yet seen)
                swap(a, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 1, 2, 1, 0};
        System.out.println("Before: " + Arrays.toString(a));
        sort012(a);
        System.out.println("After:  " + Arrays.toString(a));

        int[] b = {2, 2, 1, 0, 0, 1};
        System.out.println("Before: " + Arrays.toString(b));
        sort012(b);
        System.out.println("After:  " + Arrays.toString(b));

        int[] c = {1, 0, 2};
        System.out.println("Before: " + Arrays.toString(c));
        sort012(c);
        System.out.println("After:  " + Arrays.toString(c));

        // needs mid <= high (not mid < high) — see class comment
        int[] d = {1, 0};
        System.out.println("Before: " + Arrays.toString(d));
        sort012(d);
        System.out.println("After:  " + Arrays.toString(d));
    }
}
