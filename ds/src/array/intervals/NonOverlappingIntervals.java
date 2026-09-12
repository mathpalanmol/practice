package array.intervals;

import java.util.Arrays;

/**
 * Non-overlapping Intervals (LeetCode #435)
 *
 * <p>Given intervals, return the minimum number of intervals to remove so the rest are
 * pairwise non-overlapping.
 *
 * <p>Constraints: {@code 1 <= intervals.length <= 10^5}; {@code end > start}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Sort intervals by end {@code a[1]}.</li>
 *   <li>{@code kept = 0}, {@code end = Integer.MIN_VALUE}.</li>
 *   <li>For each {@code iv}: if {@code iv[0] &gt;= end}, {@code kept++}, {@code end = iv[1]}.</li>
 *   <li>Return {@code intervals.length - kept} removals.</li>
 * </ol>
 * <p>Time: O(n log n), Space: O(1)
 *
 * <pre>
 * Input:  intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Step:   keep [1,2],[2,3],[3,4]; skip overlapping [1,3]
 * Output: 1
 * </pre>
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int kept = 0, end = Integer.MIN_VALUE;
        for (int[] iv : intervals) {
            if (iv[0] >= end) {
                kept++;
                end = iv[1]; // greedy: keep this interval, block until its end
            }
        }
        return intervals.length - kept;
    }

    public static void main(String[] args) {
        int[][] iv = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Removals needed: " + eraseOverlapIntervals(iv));
    }
}
