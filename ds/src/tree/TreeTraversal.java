package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Binary tree traversal utilities.
 *
 * <p>Sample tree used in {@link #buildSampleTree()} and demos:
 * <pre>
 *           1
 *         /   \
 *        2     3
 *       / \   / \
 *      4   5 6   7
 * </pre>
 *
 * <p>Quick reference (on that sample):
 * <ul>
 *   <li>Inorder:   4 2 5 1 6 3 7</li>
 *   <li>Preorder:  1 2 4 5 3 6 7</li>
 *   <li>Postorder: 4 5 2 6 7 3 1</li>
 *   <li>Level:     1 2 3 4 5 6 7</li>
 *   <li>Zigzag:    [1] [3 2] [4 5 6 7]</li>
 *   <li>Boundary:  1 2 4 5 6 7 3</li>
 *   <li>Vertical:  [4] [2] [1 5 6] [3] [7]</li>
 * </ul>
 */
public class TreeTraversal {

    /** Simple binary tree node used by this class (left / right children). */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // -------------------- In-order: Left → Root → Right --------------------
    // Useful for BSTs: inorder visits keys in sorted order.

    /** Inorder DFS (recursive). */
    public static List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private static void inorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left, result);  // 1. left subtree
        result.add(root.val);                 // 2. visit root
        inorderRecursive(root.right, result); // 3. right subtree
    }

    /**
     * Inorder DFS (iterative) using a stack.
     * Go as left as possible (pushing), then pop/visit, then go right.
     */
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // dive to leftmost node, remembering parents on the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();      // next node to visit
            result.add(curr.val);
            curr = curr.right;       // then explore its right subtree
        }
        return result;
    }

    // -------------------- Pre-order: Root → Left → Right --------------------
    // Useful for cloning a tree / prefix expression of the structure.

    /** Preorder DFS (recursive). */
    public static List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private static void preorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);                  // 1. visit root first
        preorderRecursive(root.left, result);  // 2. left
        preorderRecursive(root.right, result); // 3. right
    }

    /**
     * Preorder DFS (iterative).
     * Stack is LIFO: push right before left so left is processed next.
     */
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // push right first so left comes off the stack first
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // -------------------- Post-order: Left → Right → Root --------------------
    // Useful for deleting a tree / evaluating expression trees (children first).

    /** Postorder DFS (recursive). */
    public static List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private static void postorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderRecursive(root.left, result);  // 1. left
        postorderRecursive(root.right, result); // 2. right
        result.add(root.val);                   // 3. visit root last
    }

    /**
     * Postorder DFS (iterative) via reverse of (root → right → left).
     * Collect root-right-left, then reverse the list → left-right-root.
     */
    public static List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // opposite of preorder push order → builds root, right, left
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result); // now left, right, root
        return result;
    }

    // -------------------- Level order (BFS) --------------------
    // Visit level by level, top to bottom, left to right.

    /**
     * BFS / level-order as a flat list.
     * Queue: process front, enqueue its children at the back.
     */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * BFS grouped by level, e.g. [[1], [2, 3], [4, 5, 6, 7]].
     * Process exactly {@code queue.size()} nodes per level.
     */
    public static List<List<Integer>> levelOrderByLevels(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // nodes currently on this level
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    // -------------------- Zigzag / spiral --------------------

    /**
     * Zigzag (spiral) level order:
     * even levels left→right, odd levels right→left.
     * Same BFS as level order; only the order of adding into {@code level} changes.
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);  // append → left to right
                } else {
                    level.addFirst(node.val); // prepend → right to left
                }
                // children always enqueued left then right (normal BFS)
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight; // flip direction each level
        }
        return result;
    }

    // -------------------- Vertical order --------------------

    /**
     * Vertical order traversal (top to bottom, left to right within a column).
     *
     * <p>Assign each node a column index (horizontal distance):
     * root = 0, left child = col - 1, right child = col + 1.
     * Use BFS so nodes higher in the tree appear before lower ones in the same column.
     * TreeMap keeps columns sorted from leftmost to rightmost.
     *
     * <p>Sample:
     * <pre>
     * col: -2  -1   0   1   2
     *       4   2  1,5,6  3   7
     * </pre>
     */
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // column index → nodes in that column (top to bottom)
        Map<Integer, List<Integer>> columns = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        nodeQueue.offer(root);
        colQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();

            columns.computeIfAbsent(col, c -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1); // left column
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1); // right column
            }
        }

        result.addAll(columns.values());
        return result;
    }

    // -------------------- Other common traversals --------------------

    /**
     * Boundary traversal in anti-clockwise order:
     * root → left boundary (top-down, no leaves) → all leaves (left to right)
     * → right boundary (bottom-up, no leaves).
     *
     * <p>Sample: 1 → 2 → 4 → 5 → 6 → 7 → 3
     */
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        addLeftBoundary(root.left, result);   // exclude root and leaves
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result); // exclude root and leaves; reverse
        return result;
    }

    /** Walk down preferring left child; skip leaves. */
    private static void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            node = (node.left != null) ? node.left : node.right;
        }
    }

    /** Walk down preferring right child; collect then reverse for bottom-up order. */
    private static void addRightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.val);
            }
            node = (node.right != null) ? node.right : node.left;
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }

    /** Add all leaf nodes in left-to-right order (DFS). */
    private static void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * Left view: first node visible when looking from the left
     * (first node of each depth / level).
     */
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftView(root, 0, result);
        return result;
    }

    private static void leftView(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }
        // first time we reach this depth → leftmost node
        if (depth == result.size()) {
            result.add(node.val);
        }
        leftView(node.left, depth + 1, result);  // left first
        leftView(node.right, depth + 1, result);
    }

    /**
     * Right view: first node visible from the right
     * (rightmost node of each depth).
     */
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }

    private static void rightView(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        // visit right first so the first node at a depth is the rightmost
        rightView(node.right, depth + 1, result);
        rightView(node.left, depth + 1, result);
    }

    /** Number of nodes on the longest root-to-leaf path. */
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // -------------------- Sample tree + demo --------------------

    /**
     * Build the sample tree used by {@code main}:
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
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

        System.out.println("Inorder   (rec): " + inorderRecursive(root));
        System.out.println("Inorder   (itr): " + inorderIterative(root));
        System.out.println("Preorder  (rec): " + preorderRecursive(root));
        System.out.println("Preorder  (itr): " + preorderIterative(root));
        System.out.println("Postorder (rec): " + postorderRecursive(root));
        System.out.println("Postorder (itr): " + postorderIterative(root));
        System.out.println("Level order:     " + levelOrder(root));
        System.out.println("By levels:       " + levelOrderByLevels(root));
        System.out.println("Zigzag:          " + zigzagLevelOrder(root));
        System.out.println("Boundary:        " + boundaryTraversal(root));
        System.out.println("Vertical:        " + verticalOrder(root));
        System.out.println("Left view:       " + leftView(root));
        System.out.println("Right view:      " + rightView(root));
        System.out.println("Height:          " + height(root));
    }
}
