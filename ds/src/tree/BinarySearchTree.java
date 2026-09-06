package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Search Tree problems (interview section).
 *
 * <p>BST invariant: for every node, all values in the left subtree are &lt; node,
 * and all values in the right subtree are &gt; node.
 *
 * <p>Covers: search, insert, delete, validate BST, kth smallest,
 * LCA in BST, inorder successor, recover BST (two nodes swapped).
 *
 * <pre>
 * Sample BST used in {@link #main}:
 *           5
 *         /   \
 *        3     7
 *       / \   /
 *      2   4 6
 *
 * Inorder (sorted): 2, 3, 4, 5, 6, 7
 * </pre>
 */
public class BinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Search in a Binary Search Tree (LeetCode #700)
     *
     * <p>Return the node with value {@code key}, or null if not present.
     *
     * <p>Approach: walk left if key &lt; current, right if key &gt; current.
     * O(h) time where h is tree height.
     */
    public static TreeNode search(TreeNode root, int key) {
        while (root != null && root.val != key) {
            root = (key < root.val) ? root.left : root.right;
        }
        return root;
    }

    /**
     * Insert into a Binary Search Tree (LeetCode #701)
     *
     * <p>Insert {@code key} as a new leaf while preserving the BST property.
     * Duplicate keys are ignored (no insert).
     *
     * <p>Approach: recurse left/right until a null child slot is found.
     */
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    /**
     * Delete Node in a BST (LeetCode #450)
     *
     * <p>Delete the node with value {@code key} and return the (possibly new) root.
     *
     * <p>Cases when the key node is found:
     * <ul>
     *   <li>No left child → replace with right subtree</li>
     *   <li>No right child → replace with left subtree</li>
     *   <li>Two children → copy inorder successor (min of right subtree) into
     *       this node, then delete that successor from the right subtree</li>
     * </ul>
     */
    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode successor = minNode(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }
        return root;
    }

    /** Leftmost (minimum) node in a non-null BST subtree. */
    private static TreeNode minNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Validate Binary Search Tree (LeetCode #98)
     *
     * <p>Return true if the tree is a valid BST (strict inequalities).
     *
     * <p>Approach: each node must lie in an open range (min, max).
     * Left child gets (min, root.val); right child gets (root.val, max).
     * Use long bounds to avoid int overflow at Integer.MIN/MAX_VALUE.
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    /**
     * Kth Smallest Element in a BST (LeetCode #230)
     *
     * <p>Return the k-th smallest value (1-based). Inorder of a BST is sorted,
     * so the k-th visited node in inorder is the answer.
     *
     * <p>Approach: iterative inorder with a stack; decrement k on each visit.
     */
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    /**
     * Lowest Common Ancestor of a Binary Search Tree (LeetCode #235)
     *
     * <p>Find LCA of nodes p and q. Unlike a general binary tree, BST ordering
     * lets us walk from the root without recursion on both sides.
     *
     * <p>Approach: while both keys are on the same side of root, go that way.
     * The first node that sits between (or equals) p and q is the LCA.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * Inorder Successor in BST (LeetCode #285)
     *
     * <p>Return the node with the smallest key strictly greater than {@code node},
     * or null if none exists.
     *
     * <p>Cases:
     * <ul>
     *   <li>If {@code node} has a right child → successor is the leftmost node
     *       of that right subtree</li>
     *   <li>Otherwise walk from root: whenever we go left, remember that ancestor
     *       as a candidate successor</li>
     * </ul>
     */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            return minNode(node.right);
        }
        TreeNode successor = null;
        while (root != null) {
            if (node.val < root.val) {
                successor = root;
                root = root.left;
            } else if (node.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    }

    /**
     * Recover Binary Search Tree (LeetCode #99)
     *
     * <p>Exactly two nodes in the BST were swapped by mistake. Recover the tree
     * without changing its structure (swap the two values back).
     *
     * <p>Approach: inorder should be strictly increasing. Find the violation(s):
     * <ul>
     *   <li>Adjacent swap → one descent; swap those two nodes</li>
     *   <li>Non-adjacent swap → two descents; swap the first high with the last low</li>
     * </ul>
     * Track {@code prev}, {@code first}, {@code second} during inorder, then swap values.
     */
    public static void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3]; // prev, first, second
        recoverInorder(root, nodes);
        if (nodes[1] != null && nodes[2] != null) {
            int temp = nodes[1].val;
            nodes[1].val = nodes[2].val;
            nodes[2].val = temp;
        }
    }

    private static void recoverInorder(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return;
        }
        recoverInorder(root.left, nodes);
        if (nodes[0] != null && nodes[0].val > root.val) {
            if (nodes[1] == null) {
                nodes[1] = nodes[0]; // first misplaced (too large)
            }
            nodes[2] = root; // last misplaced (too small)
        }
        nodes[0] = root;
        recoverInorder(root.right, nodes);
    }

    /** Helper: inorder values (sorted order for a valid BST). */
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

    /** Builds the sample BST shown in the class javadoc. */
    public static TreeNode buildSampleBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleBST();
        System.out.println("Inorder: " + inorder(root));
        System.out.println("Search 4: " + (search(root, 4) != null));
        System.out.println("Valid BST: " + isValidBST(root));
        System.out.println("kth smallest k=3: " + kthSmallest(root, 3));

        TreeNode p = search(root, 2);
        TreeNode q = search(root, 4);
        System.out.println("LCA(2,4): " + lowestCommonAncestor(root, p, q).val);

        TreeNode n4 = search(root, 4);
        System.out.println("Successor of 4: " + inorderSuccessor(root, n4).val);

        root = insert(root, 8);
        System.out.println("After insert 8: " + inorder(root));
        root = delete(root, 3);
        System.out.println("After delete 3: " + inorder(root));

        // recover: swap 2 and 7 in a fresh tree
        TreeNode broken = buildSampleBST();
        int t = broken.left.left.val;
        broken.left.left.val = broken.right.val;
        broken.right.val = t;
        System.out.println("Broken inorder: " + inorder(broken));
        recoverTree(broken);
        System.out.println("Recovered inorder: " + inorder(broken));
    }
}
