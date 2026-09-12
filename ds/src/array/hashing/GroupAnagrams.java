package array.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams (LeetCode #49)
 *
 * <p>Given an array of strings {@code strs}, group the anagrams together. An anagram uses
 * the same letters with a different order. Return groups in any order; strings within a
 * group may be in any order.
 *
 * <p>Constraints: up to {@code 10^4} strings; each length up to 100; lowercase letters only.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Create map {@code groups}: sorted-key string → list of original strings.</li>
 *   <li>For each string {@code s}, copy to {@code char[] c}, {@code Arrays.sort(c)}, use {@code new String(c)} as key.</li>
 *   <li>{@code groups.computeIfAbsent(key, …).add(s)}.</li>
 *   <li>Return {@code new ArrayList<>(groups.values())}.</li>
 * </ol>
 * <p>Time: O(n · k log k) for n strings of length k, Space: O(n · k)
 *
 * <pre>
 * Input:  strs = ["eat","tea","tan","ate","nat","bat"]
 * Step:   key "aet" → eat,tea,ate; key "ant" → tan,nat; key "abt" → bat
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]  (order may vary)
 * </pre>
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c); // anagrams share the same sorted key
            String key = new String(c);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Groups: " + groupAnagrams(strs));
    }
}
