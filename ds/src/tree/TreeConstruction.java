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
     * <p>Approach: take next preorder value as root, find its index in inorder,
     * then recursively build left then right. Use a map for O(1) inorder lookups.
     * {@code preIdx} is a shared cursor into the preorder array.
     */
    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndex = indexMap(inorder);
        return buildPreIn(preorder, new int[]{0}, 0, inorder.length - 1, inIndex);
    }

    private static TreeNode buildPreIn(int[] preorder, int[] preIdx,
                                       int inL, int inR, Map<Integer, Integer> inIndex) {
        if (inL > inR) {
            return null;
        }
        int rootVal = preorder[preIdx[0]++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inIndex.get(rootVal);
        root.left = buildPreIn(preorder, preIdx, inL, mid - 1, inIndex);
        root.right = buildPreIn(preorder, preIdx, mid + 1, inR, inIndex);
        return root;
    }

    /**
     * Construct Binary Tree from Inorder and Postorder Traversal (LeetCode #106)
     *
     * <p>Postorder: last element is always the root.
     * Inorder still splits left/right subtrees around the root.
     *
     * <p>Approach: consume postorder from the end. Build <em>right</em> subtree
     * before left, because postorder is left → right → root (so walking backward
     * is root → right → left).
     */
    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inIndex = indexMap(inorder);
        return buildPostIn(postorder, new int[]{postorder.length - 1}, 0, inorder.length - 1, inIndex);
    }

    private static TreeNode buildPostIn(int[] postorder, int[] postIdx,
                                        int inL, int inR, Map<Integer, Integer> inIndex) {
        if (inL > inR) {
            return null;
        }
        int rootVal = postorder[postIdx[0]--];
        TreeNode root = new TreeNode(rootVal);
        int mid = inIndex.get(rootVal);
        // build right first because we consume postorder from the end
        root.right = buildPostIn(postorder, postIdx, mid + 1, inR, inIndex);
        root.left = buildPostIn(postorder, postIdx, inL, mid - 1, inIndex);
        return root;
    }

    private static Map<Integer, Integer> indexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    /**
     * Serialize and Deserialize Binary Tree (LeetCode #297) — serialize half
     *
     * <p>Encode the tree as a string so structure (including null children) is preserved
     * and can be rebuilt uniquely.
     *
     * <p>Approach: level-order (BFS). Append each node's value or {@code "null"};
     * enqueue children only for non-null nodes.
     *
     * <p>Example: {@code 1,2,3,null,null,4,5,}
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    /**
     * Serialize and Deserialize Binary Tree (LeetCode #297) — deserialize half
     *
     * <p>Rebuild the tree from the level-order string produced by {@link #serialize}.
     *
     * <p>Approach: create root from first token; for each dequeued parent, the next
     * two tokens are left and right children (skip if {@code "null"}).
     */
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode node = queue.poll();
            if (i < parts.length && !"null".equals(parts[i]) && !parts[i].isEmpty()) {
                node.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < parts.length && !"null".equals(parts[i]) && !parts[i].isEmpty()) {
                node.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     * Convert Sorted Array to Binary Search Tree (LeetCode #108)
     *
     * <p>Given a sorted array in ascending order, build a height-balanced BST
     * (for every node, left and right subtree heights differ by at most 1).
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

    /** Helper: inorder values (left → root → right). */
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

    /** Helper: preorder values (root → left → right). */
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

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode fromPre = buildFromPreIn(preorder, inorder);
        System.out.println("From pre+in → inorder:  " + inorder(fromPre));
        System.out.println("From pre+in → preorder: " + preorder(fromPre));

        TreeNode fromPost = buildFromPostIn(postorder, inorder);
        System.out.println("From post+in → inorder: " + inorder(fromPost));

        String data = serialize(fromPre);
        System.out.println("Serialized: " + data);
        TreeNode restored = deserialize(data);
        System.out.println("Deserialized inorder: " + inorder(restored));

        TreeNode bst = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println("Sorted array → BST inorder: " + inorder(bst));
        System.out.println("Sorted array → BST preorder: " + preorder(bst));
        System.out.println("Arrays used: " + Arrays.toString(preorder));
    }
}
