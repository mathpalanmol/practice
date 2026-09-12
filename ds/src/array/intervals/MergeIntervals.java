package array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Intervals (LeetCode #56)
 *
 * <p>Given array of intervals {@code intervals[i] = [start, end]}, merge all overlapping
 * intervals and return the result.
 *
 * <p>Constraints: {@code 1 <= intervals.length <= 10^4}; {@code start <= end}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Sort {@code intervals} by start {@code a[0]}.</li>
 *   <li>For each interval {@code iv}: if {@code merged} empty or {@code last.end &lt; iv[0]}, append copy of {@code iv}.</li>
 *   <li>Else set {@code last[1] = max(last[1], iv[1])}.</li>
 *   <li>Return merged as array.</li>
 * </ol>
 * <p>Time: O(n log n), Space: O(n)
 *
 * <pre>
 * Input:  intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Step:   [1,3] merges with [2,6] → [1,6]
 * Output: [[1,6],[8,10],[15,18]]
 * </pre>
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] iv : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < iv[0]) {
                merged.add(new int[] {iv[0], iv[1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], iv[1]); // overlap → extend end
            }
        }
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] in = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged: " + Arrays.deepToString(merge(in)));
    }
}
