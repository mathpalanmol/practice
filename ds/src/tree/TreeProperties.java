package tree;

/**
 * Binary tree property problems (interview section).
 *
 * <p>Covers: height, diameter, node counts, balanced check, symmetric tree,
 * identical trees, invert / mirror.
 *
 * <pre>
 * Sample tree used in {@link #main}:
 *           1
 *         /   \
 *        2     3
 *       / \   / \
 *      4   5 6   7
 *
 * Height = 3, Diameter (nodes) = 5 (e.g. 4-2-1-3-7), Nodes = 7, Leaves = 4
 * </pre>
 */
public class TreeProperties {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Maximum Depth / Height of Binary Tree (LeetCode #104)
     *
     * <p>Height = number of nodes on the longest root-to-leaf path.
     * Empty tree has height 0.
     *
     * <p>Approach: 1 + max(height(left), height(right)).
     */
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Diameter of Binary Tree (LeetCode #543)
     *
     * <p>Diameter = longest path between any two nodes.
     * Path does not have to pass through the root.
     *
     * <p>This implementation returns the number of <em>nodes</em> on that path
     * (some problems ask for edge count = nodes - 1).
     *
     * <p>Approach: at each node, candidate = leftHeight + rightHeight + 1;
     * track the global max while returning height upward.
     */
    public static int diameter(TreeNode root) {
        int[] best = {0};
        diameterHeight(root, best);
        return best[0];
    }

    /** Returns height; updates {@code best[0]} with max diameter (node count). */
    private static int diameterHeight(TreeNode root, int[] best) {
        if (root == null) {
            return 0;
        }
        int left = diameterHeight(root.left, best);
        int right = diameterHeight(root.right, best);
        best[0] = Math.max(best[0], left + right + 1);
        return 1 + Math.max(left, right);
    }

    /**
     * Count Complete Tree Nodes / Count Nodes (related to LeetCode #222)
     *
     * <p>Return the total number of nodes in the tree.
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Count Leaf Nodes
     *
     * <p>A leaf is a node with no left and no right child.
     */
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    /**
     * Balanced Binary Tree (LeetCode #110)
     *
     * <p>A tree is height-balanced if for <em>every</em> node,
     * |height(left) - height(right)| &lt;= 1.
     *
     * <p>Approach: post-order check; return -1 as a sentinel if unbalanced,
     * otherwise return height. Avoids recomputing height separately.
     */
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    /** @return height, or -1 if this subtree is unbalanced */
    private static int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkBalance(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkBalance(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    /**
     * Symmetric Tree (LeetCode #101)
     *
     * <p>Check whether the tree is a mirror of itself
     * (left subtree mirrors right subtree).
     *
     * <p>Example (symmetric):
     * <pre>
     *       1
     *      / \
     *     2   2
     *    / \ / \
     *   3  4 4  3
     * </pre>
     *
     * <p>Approach: compare pairs (left.left vs right.right) and
     * (left.right vs right.left).
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    /**
     * Same Tree (LeetCode #100)
     *
     * <p>Two trees are identical if they have the same structure and
     * the same node values at corresponding positions.
     */
    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val
                && isIdentical(a.left, b.left)
                && isIdentical(a.right, b.right);
    }

    /**
     * Invert Binary Tree (LeetCode #226)
     *
     * <p>Mirror the tree by swapping left and right children at every node.
     *
     * <pre>
     * Before:          After:
     *     1               1
     *    / \             / \
     *   2   3           3   2
     *  / \ / \         / \ / \
     * 4  5 6  7       7  6 5  4
     * </pre>
     */
    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invert(root.right);
        root.right = invert(temp);
        return root;
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
        System.out.println("Height:     " + height(root));
        System.out.println("Diameter:   " + diameter(root));
        System.out.println("Nodes:      " + countNodes(root));
        System.out.println("Leaves:     " + countLeaves(root));
        System.out.println("Balanced:   " + isBalanced(root));
        System.out.println("Symmetric:  " + isSymmetric(root));

        TreeNode copy = buildSampleTree();
        System.out.println("Identical:  " + isIdentical(root, copy));

        invert(root);
        System.out.println("After invert, root.left.val (expect 3): " + root.left.val);
    }
}
