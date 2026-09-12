package array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval (LeetCode #57)
 *
 * <p>Given sorted non-overlapping intervals and a new interval, insert/merge so result remains
 * sorted and non-overlapping.
 *
 * <p>Constraints: {@code 0 <= intervals.length <= 10^4}; intervals sorted by start.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>While intervals end before {@code newInterval[0]}, append to {@code out}.</li>
 *   <li>While interval start {@code &lt;= newInterval[1]}, merge: {@code newInterval[0]=min(...)},
 *       {@code newInterval[1]=max(...)}.</li>
 *   <li>Append merged {@code newInterval}.</li>
 *   <li>Append all remaining intervals.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Step:   merge [1,3] with [2,5] → [1,5]
 * Output: [[1,5],[6,9]]
 * </pre>
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            out.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        out.add(newInterval);
        while (i < intervals.length) {
            out.add(intervals[i++]);
        }
        return out.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        System.out.println("After insert: " + Arrays.deepToString(insert(intervals, new int[] {2, 5})));
    }
}
