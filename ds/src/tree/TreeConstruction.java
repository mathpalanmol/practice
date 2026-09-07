package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Binary tree construction problems (interview section).
 *
 * <p>Covers: build from inorder+preorder / inorder+postorder,
 * serialize / deserialize, sorted array → balanced BST.
 *
 * <pre>
 * Sample arrays for the tree:
 *           1
 *         /   \
 *        2     3
 *       / \   / \
 *      4   5 6   7
 *
 * preorder  = [1, 2, 4, 5, 3, 6, 7]   (root, left, right)
 * inorder   = [4, 2, 5, 1, 6, 3, 7]   (left, root, right)
 * postorder = [4, 5, 2, 6, 7, 3, 1]   (left, right, root)
 * </pre>
 */
public class TreeConstruction {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Construct Binary Tree from Preorder and Inorder Traversal (LeetCode #105)
     *
     * <p>Preorder: first element is always the root.
     * Inorder: everything left of root is the left subtree; right is the right subtree.
     *
     * <pre>
     * pre=[1,2,4,5,3,6,7], in=[4,2,5,1,6,3,7]
     *
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: inorder [4, 2, 5, 1, 6, 3, 7]
     * </pre>
     *
     * <p>Approach: take next preorder value as root, find its index in inorder,
     * then recursively build left then right. Use a map for O(1) inorder lookups.
     * {@code preIdx} is a shared cursor into the preorder array.
     */
 

    private Map<Integer, Integer> idxMap = new HashMap<>();
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map value -> index in inorder for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int mid = idxMap.get(rootVal);
        // Build left subtree BEFORE right (preorder order matters)
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);
        return root;
    }
}
    /**
     * Construct Binary Tree from Inorder and Postorder Traversal (LeetCode #106)
     *
     * <p>Postorder: last element is always the root.
     * Inorder still splits left/right subtrees around the root.
     *
     * <pre>
     * post=[4,5,2,6,7,3,1], in=[4,2,5,1,6,3,7]
     *
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: inorder [4, 2, 5, 1, 6, 3, 7]
     * </pre>
     *
     * <p>Approach: consume postorder from the end. Build <em>right</em> subtree
     * before left, because postorder is left → right → root (so walking backward
     * is root → right → left).
     */
    private Map<Integer, Integer> idxMap = new HashMap<>();
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;  // start from the end
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postIdx--];   // pick from the back
        TreeNode root = new TreeNode(rootVal);

        int mid = idxMap.get(rootVal);
        // Build RIGHT subtree first (postorder is consumed back-to-front)
        root.right = helper(postorder, mid + 1, right);
        root.left  = helper(postorder, left, mid - 1);
        return root;
    }

  

    /**
     * Convert Sorted Array to Binary Search Tree (LeetCode #108)
     *
     * <p>Given a sorted array in ascending order, build a height-balanced BST
     * (for every node, left and right subtree heights differ by at most 1).
     *
     * <pre>
     * Input: [-10, -3, 0, 5, 9]
     *
     *       0
     *      / \
     *    -10  5
     *      \   \
     *      -3   9
     *
     * Expected: inorder [-10, -3, 0, 5, 9], preorder [0, -10, -3, 5, 9]
     * </pre>
     *
     * <p>Approach: pick the middle element as root so left/right halves are equal-sized;
     * recurse on [left, mid) and (mid, right].
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    /**
     * Helper: inorder values (left → root → right).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [4, 2, 5, 1, 6, 3, 7]
     * </pre>
     */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    /**
     * Helper: preorder values (root → left → right).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 2, 4, 5, 3, 6, 7]
     * </pre>
     */
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    
}