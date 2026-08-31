# Practice

Java practice repository for data structures, algorithms, and object-oriented design problems.

## Structure

```
practice/
├── ds/       # Data structures & algorithms
└── design/   # System design & OOP patterns
```

## `ds` — Data Structures & Algorithms

Source lives under `ds/src/`.

| Package | Topics |
|---------|--------|
| `graph` | DAG, Dijkstra, MST (Kruskal, Prim), topological sort, islands |
| `list` | Linked lists, doubly linked lists, stacks/queues on lists, reversal, merge, cycle detection |
| `tree` | BST, AVL, heap, suffix tree, serialization, traversal |
| `trie` | Trie implementation |
| `map` | Custom hash map |
| `matrix` | 2D grid problems, rotation, spiral traversal, BFS |
| `stack` | Stack problems, expression evaluation, stack-to-queue |
| `string` | Substrings, parentheses, word break, word ladder |
| `sort` | Merge sort, quick sort, insertion sort, topological sort |
| `patternmatch` | KMP, Boyer-Moore, Rabin-Karp |

## `design` — System Design & OOP

Source lives under `design/src/`.

| Module | Topics |
|--------|--------|
| `atm` | ATM machine design |
| `banking` | Banking system |
| `battleship` | Battleship game |
| `cabfinder` | Cab / ride finder |
| `fileSystem` | File system design |
| `lift` | Elevator system |
| `restaurant` | Restaurant ordering |
| `snakeLadder` | Snake and ladder game |
| `ticktactoe` | Tic-tac-toe |
| `twitter` | Twitter-like feed |
| `urlShortner` | URL shortener |
| `ProducerConsumer` | Producer-consumer pattern |
| `MessageBrocker` | Message broker |
| `Proxy` | Proxy pattern |
| `hashing` | Hashing utilities |
| `tsp` | Traveling salesman |
| `game` | Game implementations |

## Running

Open the project in IntelliJ IDEA and mark `ds/src` and `design/src` as source roots, or compile individual files with `javac`:

```bash
cd ds/src
javac graph/DAG.java
java graph.DAG
```

## Notes

- `.iml`, `out/`, and `.class` files are gitignored (IDE-generated).
- Each Java file is typically a standalone problem with a `main` method for local testing.
