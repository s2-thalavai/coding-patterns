# Coding Patterns: Reusable Java Templates

A Spring Boot 3 / Java 17 project with templates for 31 coding-interview patterns.
Each template solves a classic LeetCode problem, and every class has JUnit 5 tests.

## Run

```bash
mvn test                 # run all unit tests
mvn spring-boot:run      # print one worked example per pattern
```

To start the app without the demo output, set `patterns.demo.enabled=false`
in `src/main/resources/application.properties`.

Requirements: JDK 17+ and Maven 3.6+. To import into an IDE, open `pom.xml` as a Maven project.

## Layout

```
src/main/java/com/leetcode/patterns
├── CodingPatternsApplication.java   Spring Boot main class
├── PatternDemoRunner.java           CommandLineRunner: one example per pattern
├── model/        ListNode, TreeNode (with ListNode.of(...), TreeNode.of(3, 9, 20, null, ...))
├── arrays/       patterns 1–7
├── linkedlist/   patterns 8–9
├── stack/        patterns 10–11
├── search/       pattern 12
├── heap/         patterns 13–15
├── tree/         patterns 16–17, 22
├── graph/        patterns 18–21
├── backtracking/ pattern 23
├── dp/           patterns 24–27
├── greedy/       pattern 28
├── bits/         pattern 29
├── matrix/       pattern 30
└── design/       pattern 31
src/test/java/... one test class per pattern class (mirrors the packages)
```

## Pattern → class map

| #  | Pattern                 | Class                              | Problems (LC #)                                   |
|----|-------------------------|------------------------------------|---------------------------------------------------|
| 1  | Two Pointers            | `arrays.TwoPointers`               | 167, 26, 15                                       |
| 2  | Sliding Window          | `arrays.SlidingWindow`             | 3, 209, fixed-size window                         |
| 3  | Prefix Sum              | `arrays.PrefixSum`                 | 560, 303                                          |
| 4  | Hashing                 | `arrays.Hashing`                   | 1, 49, 128                                        |
| 5  | Cyclic Sort             | `arrays.CyclicSort`                | 41, 442                                           |
| 6  | Merge Intervals         | `arrays.MergeIntervals`            | 56, 253                                           |
| 7  | Kadane                  | `arrays.Kadane`                    | 53, 152                                           |
| 8  | Fast & Slow Pointers    | `linkedlist.FastSlowPointers`      | 876, 141, 142, 202                                |
| 9  | In-place Reversal       | `linkedlist.LinkedListReversal`    | 206, 92, 25                                       |
| 10 | Monotonic Stack         | `stack.MonotonicStack`             | 739, 503, 84                                      |
| 11 | Monotonic Deque         | `stack.MonotonicDeque`             | 239                                               |
| 12 | Modified Binary Search  | `search.BinarySearch`              | lower/upper bound, 33, 875                        |
| 13 | Top K Elements          | `heap.TopK`                        | 215, 347, 973                                     |
| 14 | Two Heaps               | `heap.MedianFinder`                | 295                                               |
| 15 | K-way Merge             | `heap.KWayMerge`                   | 23, 378                                           |
| 16 | Tree DFS                | `tree.TreeDfs`                     | 104, 543, 113, 98, 236                            |
| 17 | Tree BFS                | `tree.TreeBfs`                     | 102, 199, 111                                     |
| 18 | Graph BFS / DFS         | `graph.GraphTraversal`             | 200, 994, unweighted shortest path, 323           |
| 19 | Topological Sort        | `graph.TopologicalSort`            | 210, 207                                          |
| 20 | Union-Find              | `graph.UnionFind`                  | 684, 547                                          |
| 21 | Shortest Path           | `graph.ShortestPath`               | 743 (Dijkstra), 787 (Bellman-Ford)                |
| 22 | Trie                    | `tree.Trie`                        | 208, 211                                          |
| 23 | Backtracking            | `backtracking.Backtracking`        | 78, 90, 46, 39, 52                                |
| 24 | 1D DP                   | `dp.OneDimensionalDp`              | 70, 198, 322, 300, 139                            |
| 25 | 2D / String DP          | `dp.TwoDimensionalDp`              | 62, 64, 1143, 72                                  |
| 26 | Knapsack DP             | `dp.KnapsackDp`                    | 416, 494, 518                                     |
| 27 | Interval DP             | `dp.IntervalDp`                    | 312, 5                                            |
| 28 | Greedy                  | `greedy.Greedy`                    | 55, 45, 435, 134                                  |
| 29 | Bit Manipulation        | `bits.BitManipulation`             | 136, 338, 191, 231, bitmask subsets               |
| 30 | Matrix Traversal        | `matrix.MatrixTraversal`           | 54, 48, 73                                        |
| 31 | Design                  | `design.LRUCache`, `design.MinStack` | 146, 155                                        |

## Conventions

- Pattern classes are `final` utility classes with static methods. Stateful structures
  (`MedianFinder`, `Trie`, `UnionFind`, `LRUCache`, `MinStack`) are regular classes.
- `// CHANGE` comments mark the lines you adapt when reusing a template on a new problem.
- Javadoc on each method gives the LeetCode number and the key idea.
- Methods that modify their input say so in the Javadoc (cyclic sort, numIslands,
  orangesRotting, matrix rotate/setZeroes). Sorting templates sort a copy.
- Tests cover the LeetCode samples plus edge cases (empty input, negatives, overflow,
  duplicates). Several use `@ParameterizedTest` + `@CsvSource`.

## Adding a new problem

1. Add a static method to the matching pattern class (or a new class in that package).
2. Add a test method to the mirrored test class.
3. Optionally add a line to `PatternDemoRunner`.
