package array.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Top K Frequent Elements (LeetCode #347)
 *
 * <p>Given integer array {@code nums} and integer {@code k}, return the {@code k} most
 * frequent elements. Answer is unique; order of returned values does not matter.
 *
 * <p>Constraints: {@code 1 <= k <= number of distinct elements}; follow-up asks for better
 * than {@code O(n log n)} — bucket sort by frequency achieves {@code O(n)}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Count each value in hash map {@code freq} via {@code freq.merge(x, 1, Integer::sum)}.</li>
 *   <li>Allocate {@code buckets[f]} lists for {@code f = 0 .. nums.length}; place each distinct value in {@code buckets[its frequency]}.</li>
 *   <li>Scan {@code f} from {@code buckets.length - 1} down to 0; append all values in {@code buckets[f]} to output until {@code k} collected.</li>
 *   <li>Return the {@code k}-length array.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [1,1,1,2,2,3], k = 2
 * Step:   freq {1:3,2:2,3:1}; buckets[3]=[1], [2]=[2] → take 1 then 2
 * Output: [1, 2]
 * </pre>
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(e.getKey());
        }
        int[] out = new int[k];
        int p = 0;
        for (int f = buckets.length - 1; f >= 0 && p < k; f--) {
            if (buckets[f] == null) {
                continue;
            }
            for (int x : buckets[f]) {
                out[p++] = x;
                if (p == k) {
                    return out;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2 frequent: " + Arrays.toString(topKFrequent(nums, 2)));
    }
}
