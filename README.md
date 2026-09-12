# Practice

Java practice repository for data structures and algorithms.

## Structure

```
practice/
└── ds/       # Data structures & algorithms
```

## `ds` — Data Structures & Algorithms

Source lives under `ds/src/`.

| Package | Topics |
|---------|--------|
| `array` | FAANG array patterns by category (see below) |
| `graph` | DAG, Dijkstra, MST (Kruskal, Prim), topological sort, islands |
| `list` | Linked lists, doubly linked lists, stacks/queues on lists, reversal, merge, cycle detection |
| `tree` | TreeTraversal, TreeProperties, TreePaths, TreeConstruction, BinarySearchTree, heap |
| `trie` | Trie implementation |
| `map` | Custom hash map |
| `matrix` | 2D grid problems, rotation, spiral traversal, BFS |
| `stack` | Stack problems, expression evaluation, stack-to-queue |
| `string` | Substrings, parentheses, word break, word ladder |
| `sort` | Merge sort, quick sort, insertion sort, topological sort |
| `patternmatch` | KMP, Boyer-Moore, Rabin-Karp |

### `array` subpackages

```
array/
├── twopointers/    # Sort 0/1, Sort 0/1/2, Two Sum II, 3Sum, Container, Trapping Rain, Move Zeroes…
├── prefixsum/      # Max Subarray, Product Except Self, Subarray Sum = K, Contiguous Array…
├── slidingwindow/  # Min Size Subarray, Sliding Window Max, Max Consecutive Ones III…
├── binarysearch/   # Rotated search/min, First/Last position, Peak, Search 2D Matrix
├── intervals/      # Merge/Insert intervals, Merge Sorted Array, Non-overlapping
├── hashing/        # Two Sum, Top K Frequent, Contains Duplicate, Longest Consecutive, Group Anagrams
├── inplace/        # First Missing Positive, Find Duplicate, Disappeared Numbers, Rotate Array
├── greedy/         # Buy/Sell Stock, Jump Game, Next Permutation, Gas Station
├── matrix/         # Spiral, Rotate Image, Set Zeroes, Search 2D II
└── hard/           # Median of Two Sorted Arrays, Largest Rectangle, Maximal Rectangle
```

## Running

Open the project in IntelliJ IDEA and mark `ds/src` as a source root, or compile individual files with `javac`:

```bash
cd ds/src
javac graph/DAG.java
java graph.DAG
```

## Notes

- `.iml`, `out/`, and `.class` files are gitignored (IDE-generated).
- Each Java file is typically a standalone problem with a `main` method for local testing.
