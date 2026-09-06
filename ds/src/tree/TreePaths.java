package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary tree path problems (interview section).
 *
 * <p>Covers: root-to-leaf paths, path sum, max path sum, LCA, distance between nodes.
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
     * <p>Example: path 1→2→5 sums to 8 → true for target 8.
     *
     * <p>Approach: subtract current value and recurse; at a leaf, check equality.
     */
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        int remaining = target - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    /**
     * Path Sum II (LeetCode #113)
     *
     * <p>Return <em>all</em> root-to-leaf paths whose values sum to {@code target}.
     *
     * <p>Same backtracking pattern as {@link #rootToLeafPaths}, with a remaining-sum check.
     */
    public static List<List<Integer>> pathSumAll(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumAll(root, target, new ArrayList<>(), result);
        return result;
    }

    private static void pathSumAll(TreeNode node, int remaining, List<Integer> path,
                                   List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            pathSumAll(node.left, remaining - node.val, path, result);
            pathSumAll(node.right, remaining - node.val, path, result);
        }
        path.remove(path.size() - 1);
    }

    /**
     * Binary Tree Maximum Path Sum (LeetCode #124)
     *
     * <p>A path is any sequence of connected nodes (need not pass through root).
     * Find the path with the maximum sum of node values.
     * Node values may be negative.
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
     * <p>Approach: dist(p, q) = depth(LCA, p) + depth(LCA, q).
     */
    public static int distance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        return depth(lca, p, 0) + depth(lca, q, 0);
    }

    /** Depth of {@code target} under {@code root}, or -1 if not found. */
    private static int depth(TreeNode root, TreeNode target, int d) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return d;
        }
        int left = depth(root.left, target, d + 1);
        if (left != -1) {
            return left;
        }
        return depth(root.right, target, d + 1);
    }

    /** Builds the sample tree shown in the class javadoc. */
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
        System.out.println("Max path sum: " + maxPathSum(root));
        System.out.println("LCA(4,5).val: " + lowestCommonAncestor(root, n4, n5).val);
        System.out.println("LCA(4,7).val: " + lowestCommonAncestor(root, n4, n7).val);
        System.out.println("Distance(4,5): " + distance(root, n4, n5));
        System.out.println("Distance(4,7): " + distance(root, n4, n7));
    }
}
