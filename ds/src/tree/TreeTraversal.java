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
 *   <li>Inorder left->root->right:   4 2 5 1 6 3 7</li>
 *   <li>Preorder root->left->right:  1 2 4 5 3 6 7</li>
 *   <li>Postorder left->right->root: 4 5 2 6 7 3 1</li>
 *   <li>Level:     1 2 3 4 5 6 7</li>
 *   <li>Zigzag:    [1] [3 2] [4 5 6 7]</li>
 *   <li>Boundary:  1 2 4 5 6 7 3</li>
 *   <li>Vertical:  [4] [2] [1 5 6] [3] [7]</li>
 *   <li>Top view:  4 2 1 3 7 · Bottom: 4 2 6 3 7</li>
 *   <li>Left/Right view: 1 2 4 / 1 3 7</li>
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

    /**
     * Inorder DFS (recursive). Left → Root → Right.
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
     * Inorder DFS (iterative) using a stack. Left → Root → Right.
     * Go as left as possible (pushing), then pop/visit, then go right.
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

    /**
     * Preorder DFS (recursive). Root → Left → Right.
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
     * Preorder DFS (iterative). Root → Left → Right.
     * Stack is LIFO: push right before left so left is processed next.
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

    /**
     * Postorder DFS (recursive). Left → Right → Root.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [4, 5, 2, 6, 7, 3, 1]
     * </pre>
     */
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
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [4, 5, 2, 6, 7, 3, 1]
     * </pre>
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
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 2, 3, 4, 5, 6, 7]
     * </pre>
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
     * Binary Tree Level Order Traversal (LeetCode #102)
     *
     * <p>Return the node values level by level, left to right, as a list of lists.
     * Level 0 is the root; each next list is one deeper level.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [[1], [2, 3], [4, 5, 6, 7]]
     * </pre>
     *
     * <p>Approach: BFS with a queue. At the start of each level, {@code queue.size()}
     * is exactly the number of nodes on that level — process that many, enqueueing
     * their children for the next level.
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
     * Binary Tree Zigzag Level Order Traversal (LeetCode #103)
     *
     * <p>Zigzag (spiral) level order: even levels left→right, odd levels right→left.
     * Same BFS as level order; only the order of adding into {@code level} changes.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [[1], [3, 2], [4, 5, 6, 7]]
     * </pre>
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
     * <p>Give each node a column: root = 0, left = col - 1, right = col + 1.
     * BFS visits top nodes first; TreeMap keeps columns left → right.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * col: -2  -1   0   1   2
     *       4   2  1,5,6  3   7
     *
     * Expected: [[4], [2], [1, 5, 6], [3], [7]]
     * </pre>
     */
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // col → values in that column (top to bottom)
        Map<Integer, List<Integer>> columns = new TreeMap<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        nodes.add(root);
        cols.add(0); // root starts at column 0

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = cols.poll();

            // add this node to its column list
            if (!columns.containsKey(col)) {
                columns.put(col, new ArrayList<>());
            }
            columns.get(col).add(node.val);

            // left child goes one column left, right one column right
            if (node.left != null) {
                nodes.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                cols.add(col + 1);
            }
        }

        // TreeMap is already sorted by column
        for (List<Integer> column : columns.values()) {
            result.add(column);
        }
        return result;
    }

    // -------------------- Top / Bottom view --------------------

    /**
     * Top View of Binary Tree (GFG / common interview)
     *
     * <p>Nodes visible when looking from above: the first node encountered
     * at each horizontal distance (column), left to right.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [4, 2, 1, 3, 7]
     * </pre>
     *
     * <p>Approach: BFS with column index (same as vertical order). Record a
     * column only the first time it is seen so the topmost node wins.
     */
    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, Integer> columns = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.offer(root);
        colQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            columns.putIfAbsent(col, node.val); // first = topmost

            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1);
            }
        }
        result.addAll(columns.values());
        return result;
    }

    /**
     * Bottom View of Binary Tree (GFG / common interview)
     *
     * <p>Nodes visible when looking from below: the last node at each
     * horizontal distance. If two nodes share a column, the deeper (or later
     * in BFS at same depth) overwrites. (5 and 6 share col 0 with 1; last wins → 6)
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [4, 2, 6, 3, 7]
     * </pre>
     *
     * <p>Approach: same BFS as {@link #topView}, but always overwrite the column.
     */
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, Integer> columns = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.offer(root);
        colQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            columns.put(col, node.val); // last = bottommost

            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1);
            }
        }
        result.addAll(columns.values());
        return result;
    }

    

    /**
     * Find Largest Value in Each Tree Row (LeetCode #515)
     *
     * <p>Return the largest value in each level of the tree.
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 3, 7]
     * </pre>
     *
     * <p>Approach: BFS by levels; track max while processing each level.
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    // -------------------- Next right pointers --------------------

    /**
     * Node with a {@code next} pointer for "populate next right" problems.
     */
    public static class NextNode {
        int val;
        NextNode left;
        NextNode right;
        NextNode next;

        NextNode(int val) {
            this.val = val;
        }
    }

    /**
     * Populating Next Right Pointers in Each Node (LeetCode #116 / #117)
     *
     * <p>Connect each node's {@code next} to the next node on the same level
     * (rightward). The rightmost node's {@code next} is null.
     *
     * <p>#116 assumes a perfect binary tree; #117 is the general case.
     * This BFS solution works for both.
     *
     * <pre>
     * Before:              After:
     *     1                1 → null
     *    / \              / \
     *   2   3            2 → 3 → null
     *  / \ / \          / \ / \
     * 4  5 6  7        4→5→6→7 → null
     *
     * Expected: levels 1→null; 2→3→null; 4→5→6→7→null
     * </pre>
     *
     * <p>Approach: level-order BFS; link consecutive nodes in the same level.
     */
    public static NextNode connect(NextNode root) {
        if (root == null) {
            return null;
        }

        Queue<NextNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            NextNode prev = null;
            for (int i = 0; i < size; i++) {
                NextNode node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * Perfect-tree O(1)-extra-space connect (LeetCode #116 only).
     *
     * <p>Use already-established {@code next} links on the current level to
     * wire the children on the next level — no queue needed.
     *
     * <pre>
     * Before:              After:
     *     1                1 → null
     *    / \              / \
     *   2   3            2 → 3 → null
     *  / \ / \          / \ / \
     * 4  5 6  7        4→5→6→7 → null
     *
     * Expected: levels 1→null; 2→3→null; 4→5→6→7→null
     * </pre>
     */
    public static NextNode connectPerfect(NextNode root) {
        if (root == null) {
            return null;
        }
        NextNode leftmost = root;
        while (leftmost.left != null) {
            NextNode head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    /**
     * Build a perfect tree of depth 3 for next-pointer demos (values 1..7).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: perfect tree with values 1..7 (next pointers unset)
     * </pre>
     */
    public static NextNode buildSampleNextTree() {
        NextNode root = new NextNode(1);
        root.left = new NextNode(2);
        root.right = new NextNode(3);
        root.left.left = new NextNode(4);
        root.left.right = new NextNode(5);
        root.right.left = new NextNode(6);
        root.right.right = new NextNode(7);
        return root;
    }

    /** Print levels using {@code next} links (one line per level starting at leftmost). */
    private static void printNextLevels(NextNode root) {
        NextNode leftmost = root;
        while (leftmost != null) {
            NextNode curr = leftmost;
            while (curr != null) {
                System.out.print(curr.val);
                if (curr.next != null) {
                    System.out.print(" → ");
                }
                curr = curr.next;
            }
            System.out.println(" → null");
            leftmost = leftmost.left; // perfect tree: leftmost of next level
        }
    }

    // -------------------- Other common traversals --------------------

    /**
     * Boundary traversal in anti-clockwise order:
     * root → left boundary (top-down, no leaves) → all leaves (left to right)
     * → right boundary (bottom-up, no leaves).
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 2, 4, 5, 6, 7, 3]
     * </pre>
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
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 2, 4]
     * </pre>
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
     *
     * <pre>
     *           1
     *         /   \
     *        2     3
     *       / \   / \
     *      4   5 6   7
     *
     * Expected: [1, 3, 7]
     * </pre>
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

    /**
     * Maximum depth / height (recursive).
     * Number of nodes on the longest root-to-leaf path.
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
     */
    public static int heightRecursive(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = heightRecursive(root.left);
        int rightDepth = heightRecursive(root.right);

        // Depth of current node = 1 + longer subtree
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Maximum depth / height (iterative).
     * Same as {@link #heightRecursive} — count BFS levels.
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
     * <p>Approach: level-order BFS. Each time the queue has nodes, that is one level;
     * increment a counter until the queue is empty.
     */
    public static int heightIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // nodes on this level
            height++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }

    /** Same as {@link #heightRecursive}; kept as a short alias. */
    public static int height(TreeNode root) {
        return heightRecursive(root);
    }

    // -------------------- Sample tree + demo --------------------

    /**
     * Build the sample tree used by {@code main}.
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
        System.out.println("Top view:        " + topView(root));
        System.out.println("Bottom view:     " + bottomView(root));
        System.out.println("Max per level:   " + largestValues(root));
        System.out.println("Left view:       " + leftView(root));
        System.out.println("Right view:      " + rightView(root));
        System.out.println("Height (rec):    " + heightRecursive(root));
        System.out.println("Height (itr):    " + heightIterative(root));

        System.out.println("Next pointers (BFS #116/#117):");
        printNextLevels(connect(buildSampleNextTree()));
        System.out.println("Next pointers (O(1) perfect #116):");
        printNextLevels(connectPerfect(buildSampleNextTree()));
    }
}
