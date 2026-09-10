package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary tree path / DFS problems (interview section).
 *
 * <p>Covers: root-to-leaf paths, path sum I/II/III, sum root-to-leaf numbers,
 * max path sum, flatten to linked list, House Robber III, LCA, distance,
 * path between two nodes, max depth.
 *
 * <pre>
 * Sample tree used in {@link #main}:
 *           1
 *         /   \
 *        2     3
 *       / \   / \
 *      4   5 6   7
 *
 * Paths: 1-2-4, 1-2-5, 1-3-6, 1-3-7
 * Path sum 8 → 1-2-5; LCA(4,5)=2; LCA(4,7)=1; dist(4,5)=2; dist(4,7)=4
 * </pre>
 */
public class TreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Binary Tree Paths (LeetCode #257)
     *
     * <p>Return all root-to-leaf paths. A leaf has no children.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [[1, 2, 4], [1, 2, 5], [1, 3, 6], [1, 3, 7]]
     * </pre>
     *
     * <p>Approach: DFS with a shared path list; add a copy when a leaf is reached,
     * then backtrack (remove last value) before exploring siblings.
     */
    public static List<List<Integer>> rootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void collectPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            collectPaths(node.left, path, result);
            collectPaths(node.right, path, result);
        }
        path.remove(path.size() - 1); // backtrack
    }

    /**
     * Path Sum (LeetCode #112)
     *
     * <p>Return true if the tree has a root-to-leaf path whose values sum to {@code target}.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: hasPathSum(target=8) → true (path 1-2-5)
     * </pre>
     *
     * <p>Approach: walk down adding each node to a running sum.
     * At a leaf, check if {@code sumSoFar == target}.
     * If either left or right subtree finds a valid path, return true.
     */
    public static boolean hasPathSum(TreeNode root, int target) {
        return hasPathSumHelper(root, 0, target);
    }

    /** @param sumSoFar sum of node values from root down to the parent of {@code node} */
    private static boolean hasPathSumHelper(TreeNode node, int sumSoFar, int target) {
        if (node == null) {
            return false;
        }

        sumSoFar += node.val;

        // leaf → check full path sum
        if (node.left == null && node.right == null) {
            return sumSoFar == target;
        }

        // try left or right subtree
        return hasPathSumHelper(node.left, sumSoFar, target)
                || hasPathSumHelper(node.right, sumSoFar, target);
    }

    /**
     * Path Sum II (LeetCode #113)
     *
     * <p>Return <em>all</em> root-to-leaf paths whose values sum to {@code target}.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: pathSumAll(target=8) → [[1, 2, 5]]
     * </pre>
     *
     * <p>Same idea as {@link #hasPathSum}, but collect every matching path.
     * Walk down with a running sum; at a leaf, if sum equals target, save a copy of the path.
     */
    public static List<List<Integer>> pathSumAll(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumAllHelper(root, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void pathSumAllHelper(TreeNode node, int sumSoFar, int target,
                                         List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        sumSoFar += node.val;

        // leaf with matching sum → save this path
        if (node.left == null && node.right == null) {
            if (sumSoFar == target) {
                result.add(new ArrayList<>(path));
            }
        } else {
            pathSumAllHelper(node.left, sumSoFar, target, path, result);
            pathSumAllHelper(node.right, sumSoFar, target, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }

    /**
     * Path Sum III (LeetCode #437)
     *
     * <p>Count the number of paths where the sum of node values equals {@code target}.
     * A path can start and end at any nodes, but must go downward (parent → child only).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: pathSumIII(target=7) → 3 (paths 1-2-4, 2-5, 7)
     * </pre>
     *
     * <p>Approach: prefix-sum DFS. If {@code currSum - target} was seen as a prefix,
     * there is a downward path ending at the current node with sum {@code target}.
     * Backtrack the prefix map when leaving a node.
     */
    public static int pathSumIII(TreeNode root, int target) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // empty prefix → one way to have sum 0
        return pathSumIII(root, 0L, target, prefix);
    }

    private static int pathSumIII(TreeNode node, long currSum, int target,
                                  Map<Long, Integer> prefix) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        int count = prefix.getOrDefault(currSum - target, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        count += pathSumIII(node.left, currSum, target, prefix);
        count += pathSumIII(node.right, currSum, target, prefix);
        prefix.put(currSum, prefix.get(currSum) - 1); // backtrack
        return count;
    }

    /**
     * Sum Root to Leaf Numbers (LeetCode #129)
     *
     * <p>Each root-to-leaf path forms a number (e.g. 1→2→4 → 124).
     * Return the sum of all such numbers.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: 522 (124+125+136+137)
     * </pre>
     *
     * <p>Approach: walk down building a number digit by digit ({@code numberSoFar * 10 + val}).
     * At a leaf, return that number. Otherwise add the totals from left and right subtrees.
     */
    public static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    /** @param numberSoFar number formed by values from root down to the parent of {@code node} */
    private static int sumNumbersHelper(TreeNode node, int numberSoFar) {
        if (node == null) {
            return 0;
        }

        // append current digit: 12 → 124 when node.val is 4
        numberSoFar = numberSoFar * 10 + node.val;

        // leaf → this path forms one complete number
        if (node.left == null && node.right == null) {
            return numberSoFar;
        }

        int fromLeft = sumNumbersHelper(node.left, numberSoFar);
        int fromRight = sumNumbersHelper(node.right, numberSoFar);
        return fromLeft + fromRight;
    }

    /**
     * Flatten Binary Tree to Linked List (LeetCode #114)
     *
     * <p>Flatten the tree into a "linked list" in-place using the right pointer
     * (left always null). Order must be the same as preorder.
     *
     * <pre>
     * Before (sample):         After (right spine):
     *           1                   1
     *         /   \                  \
     *        2     3                  2
     *       / \   / \                  \
     *      4   5 6   7                  4
     *                                    \
     *                                     5
     *                                      \
     *                                       3
     *                                        \
     *                                         6
     *                                          \
     *                                           7
     *
     * Expected: 1→2→4→5→3→6→7
     * </pre>
     *
     * <p>Approach: reverse-preorder (right → left → root). We build the list backwards
     * (last preorder node first), then hook each node in front via {@code node.right = prev}.
     * Helper <em>returns</em> the new head of the chain (no array / static field needed).
     */
    public static void flatten(TreeNode root) {
        flattenHelper(root, null);
    }

    /**
     * Visit right, then left, then wire current node.
     * Visit order for sample tree: 7, 6, 3, 5, 4, 2, 1.
     *
     * @param prev head of the flattened chain built so far
     * @return new head after placing {@code node} in front
     */
    private static TreeNode flattenHelper(TreeNode node, TreeNode prev) {
        if (node == null) {
            return prev; // nothing to add — keep existing head
        }

        // reverse-preorder: right before left
        prev = flattenHelper(node.right, prev);
        prev = flattenHelper(node.left, prev);

        // append already-built chain after this node
        node.right = prev;
        node.left = null;

        // this node is the new front — return it to the caller
        return node;
    }

    /**
     * House Robber III (LeetCode #337)
     *
     * <p>Each node is a house with money {@code val}. Adjacent houses (parent–child)
     * cannot both be robbed. Return the maximum amount.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: 23
     * </pre>
     *
     * <p>Approach: tree DP. For each node return {@code [robThis, skipThis]}:
     * <ul>
     *   <li>robThis = node.val + skip(left) + skip(right)</li>
     *   <li>skipThis = max(rob, skip) of left + max(rob, skip) of right</li>
     * </ul>
     */
    public static int houseRobberIII(TreeNode root) {
        int[] res = rob(root);
        return Math.max(res[0], res[1]);
    }

    /** @return {@code [robThis, skipThis]} */
    private static int[] rob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = rob(node.left);
        int[] right = rob(node.right);
        int robThis = node.val + left[1] + right[1];
        int skipThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robThis, skipThis};
    }

    /**
     * Binary Tree Maximum Path Sum (LeetCode #124)
     *
     * <p>A path is any sequence of connected nodes (need not pass through root).
     * Find the path with the maximum sum of node values.
     * Node values may be negative.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: 18 (e.g. 4-2-5 or 5-2-1-3-7)
     * </pre>
     *
     * <p>Approach: at each node, the best path <em>through</em> this node is
     * {@code node + max(0, leftGain) + max(0, rightGain)}. Track a global max.
     * Return upward only one branch: {@code node + max(0, left, right)} —
     * a parent cannot use both children.
     */
    public static int maxPathSum(TreeNode root) {
        int[] best = {Integer.MIN_VALUE};
        maxGain(root, best);
        return best[0];
    }

    /** Max contribution this subtree can add to a path going upward. */
    private static int maxGain(TreeNode node, int[] best) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxGain(node.left, best));
        int right = Math.max(0, maxGain(node.right, best));
        best[0] = Math.max(best[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }

    /**
     * Lowest Common Ancestor of a Binary Tree (LeetCode #236)
     *
     * <p>Given nodes p and q (both exist in the tree), find their lowest common
     * ancestor — the deepest node that has both as descendants (a node is a
     * descendant of itself).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4*  5* 6   7*
     *
     * Expected: LCA(4,5)=2; LCA(4,7)=1
     * </pre>
     *
     * <p>Approach: recurse left and right. If root is p or q, return root.
     * If both sides return non-null, root is the split point → LCA.
     * Otherwise return the non-null side.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    /**
     * Distance Between Two Nodes
     *
     * <p>Return the number of <em>edges</em> on the path between p and q.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4*  5* 6   7*
     *
     * Expected: distance(4,5)=2; distance(4,7)=4
     * </pre>
     *
     * <p>Approach: dist(p, q) = depth(LCA, p) + depth(LCA, q).
     */
    public static int distance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        return depth(lca, p) + depth(lca, q);
    }

    /**
     * Number of edges from {@code root} down to {@code target}, or -1 if not found.
     * No depth parameter — add 1 when returning from a successful subtree.
     */
    private static int depth(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return 0; // found at this node → 0 edges
        }

        int left = depth(root.left, target);
        if (left != -1) {
            return left + 1; // target is under left → one more edge up
        }

        int right = depth(root.right, target);
        if (right != -1) {
            return right + 1; // target is under right
        }

        return -1; // not in this subtree
    }

    /**
     * Path Between Two Nodes
     *
     * <p>Return the list of node values on the path from {@code p} to {@code q}
     * (including both ends). Uses LCA: go from p up to LCA, then down to q.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4*  5* 6   7*
     *
     * Expected: path(4,5) → [4, 2, 5]
     *           path(4,7) → [4, 2, 1, 3, 7]
     * </pre>
     *
     * <p>Approach: find LCA; get path LCA→p and LCA→q; reverse LCA→p and append
     * LCA→q without duplicating LCA.
     */
    public static List<Integer> pathBetween(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        List<Integer> toP = pathDown(lca, p); // [lca, ..., p]
        List<Integer> toQ = pathDown(lca, q); // [lca, ..., q]

        List<Integer> result = new ArrayList<>();
        // p → ... → lca
        for (int i = toP.size() - 1; i >= 0; i--) {
            result.add(toP.get(i));
        }
        // then ... → q (skip lca — already added)
        for (int i = 1; i < toQ.size(); i++) {
            result.add(toQ.get(i));
        }
        return result;
    }

    /** Path of values from {@code from} down to {@code target} (inclusive). */
    private static List<Integer> pathDown(TreeNode from, TreeNode target) {
        List<Integer> path = new ArrayList<>();
        findPathDown(from, target, path);
        return path;
    }

    private static boolean findPathDown(TreeNode node, TreeNode target, List<Integer> path) {
        if (node == null) {
            return false;
        }
        path.add(node.val);
        if (node == target) {
            return true;
        }
        if (findPathDown(node.left, target, path) || findPathDown(node.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1); // backtrack
        return false;
    }

    /**
     * Maximum Depth of Binary Tree (LeetCode #104)
     *
     * <p>Depth = number of nodes on the longest root-to-leaf path.
     * Empty tree has depth 0.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: 3
     * </pre>
     *
     * <p>Approach: recursively find depth of left and right; current depth is
     * {@code 1 + max(leftDepth, rightDepth)}.
     */
    public static int maxDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Depth of current node = 1 + longer subtree
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Builds the sample tree shown in the class javadoc.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: tree with values 1..7 as shown
     * </pre>
     */
    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        TreeNode n4 = root.left.left;
        TreeNode n5 = root.left.right;
        TreeNode n7 = root.right.right;

        System.out.println("Root-to-leaf paths: " + rootToLeafPaths(root));
        System.out.println("Has path sum 8 (1-2-5): " + hasPathSum(root, 8));
        System.out.println("All path sums = 8: " + pathSumAll(root, 8));
        System.out.println("Path Sum III target 7: " + pathSumIII(root, 7)
                + " (paths: 1-2-4, 2-5, 7)");
        System.out.println("Sum root-to-leaf numbers: " + sumNumbers(root)
                + " (124+125+136+137)");
        System.out.println("Max path sum: " + maxPathSum(root));
        System.out.println("House Robber III: " + houseRobberIII(root));
        System.out.println("LCA(4,5).val: " + lowestCommonAncestor(root, n4, n5).val);
        System.out.println("LCA(4,7).val: " + lowestCommonAncestor(root, n4, n7).val);
        System.out.println("Distance(4,5): " + distance(root, n4, n5));
        System.out.println("Distance(4,7): " + distance(root, n4, n7));
        System.out.println("Path(4,5): " + pathBetween(root, n4, n5));
        System.out.println("Path(4,7): " + pathBetween(root, n4, n7));
        System.out.println("Max depth: " + maxDepth(root));

        TreeNode flat = buildSampleTree();
        flatten(flat);
        System.out.print("Flattened right spine: ");
        TreeNode curr = flat;
        while (curr != null) {
            System.out.print(curr.val + (curr.right != null ? " -> " : ""));
            curr = curr.right;
        }
        System.out.println();
    }
}
