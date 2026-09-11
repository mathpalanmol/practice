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
| `array` | Sort 0/1, Sort 0/1/2 (Dutch National Flag), array problems |
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
