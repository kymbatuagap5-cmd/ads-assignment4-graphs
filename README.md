# Assignment 4: Graph Traversal and Representation System

## Student Information

- Name: Kymbat Uagap
- Course: Data Structures and Algorithms
- Assignment: Assignment 4
- Topic: Graph Traversal and Representation System

---

# Project Overview

This project implements graph traversal algorithms using Java and Object-Oriented Programming principles.

The graph is represented using an adjacency list structure. The program supports:

- Graph creation
- Vertex and edge management
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Performance analysis using execution time measurements

The project demonstrates how graph traversal algorithms work on graphs of different sizes.

---

# Graph Structure

A graph is a data structure consisting of:

- Vertices (nodes)
- Edges (connections between vertices)

This project uses an adjacency list representation because it is memory efficient and suitable for sparse graphs.

Example:

0 → 1, 2  
1 → 2, 3  
2 → 3, 4

---

# Project Structure

```text
assignment4-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   └── screenshots/
├── README.md
└── .gitignore
```

---

# Class Descriptions

## Vertex Class

The `Vertex` class represents a node in the graph.

### Fields
- `id` — unique identifier of the vertex

### Methods
- Constructor
- Getter
- `toString()`

### Purpose
Stores information about graph nodes.

---

## Edge Class

The `Edge` class represents a connection between two vertices.

### Fields
- `source`
- `destination`

### Methods
- Constructor
- Getters
- `toString()`

### Purpose
Represents relationships between vertices.

---

## Graph Class

The `Graph` class stores the graph using an adjacency list.

### Main Methods
- `addVertex(Vertex v)`
- `addEdge(int from, int to)`
- `printGraph()`
- `bfs(int start)`
- `dfs(int start)`

### Purpose
Handles graph operations and traversal algorithms.

---

## Experiment Class

The `Experiment` class performs testing and performance analysis.

### Main Methods
- `runTraversals(Graph g)`
- `runMultipleTests()`
- `printResults()`

### Purpose
Measures execution time and compares BFS and DFS performance.

---

# Adjacency List Representation

The graph is implemented using a `HashMap<Integer, List<Integer>>`.

Each vertex stores a list of neighboring vertices.

Example:

```text
0 -> [1, 2]
1 -> [2, 3]
2 -> [3, 4]
```

Advantages:
- Memory efficient
- Fast neighbor access
- Suitable for sparse graphs

---

# Breadth-First Search (BFS)

## Description

Breadth-First Search explores vertices level by level starting from the source vertex.

It uses a queue data structure to process vertices in FIFO order.

---

## BFS Steps

1. Start from the selected vertex
2. Mark the vertex as visited
3. Add the vertex to the queue
4. Remove a vertex from the queue
5. Visit all unvisited neighbors
6. Repeat until the queue becomes empty

---

## BFS Use Cases

- Shortest path in unweighted graphs
- Social network analysis
- Network broadcasting
- Web crawling

---

## BFS Time Complexity

```text
O(V + E)
```

Where:
- `V` = number of vertices
- `E` = number of edges

---

# Depth-First Search (DFS)

## Description

Depth-First Search explores vertices deeply before backtracking.

It uses recursion (or a stack) to traverse the graph.

---

## DFS Steps

1. Start from the selected vertex
2. Mark the vertex as visited
3. Visit an unvisited neighbor
4. Continue recursively
5. Backtrack when no unvisited neighbors remain

---

## DFS Use Cases

- Path finding
- Cycle detection
- Topological sorting
- Maze solving

---

## DFS Time Complexity

```text
O(V + E)
```

Where:
- `V` = number of vertices
- `E` = number of edges

---

# Experimental Results

The algorithms were tested on graphs of different sizes.

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|--|--|
| 10 Vertices | 2162600 | 526900 |
| 30 Vertices | 1013700 | 1395500 |
| 100 Vertices | 3107800 | 3232000 |

---

# Observations and Analysis

## How does graph size affect BFS and DFS performance?

As the graph size increases, the traversal time also increases because more vertices and edges must be processed.

---

## Which traversal was faster?

In most tests, BFS and DFS produced very similar execution times. Small differences occurred because of recursion overhead and queue operations.

---

## Do results match the expected complexity O(V + E)?

Yes. Both algorithms scale according to the number of vertices and edges because each vertex and edge is visited once.

---

## How does graph structure affect traversal order?

Traversal order depends on how vertices are connected.

- BFS visits neighbors level by level.
- DFS explores one branch deeply before returning.

Different edge configurations produce different traversal sequences.

---

## When is BFS preferred over DFS?

BFS is preferred when:
- Finding the shortest path
- Searching nearby nodes first
- Working with level-based traversal

---

## What are the limitations of DFS?

DFS limitations include:
- Does not guarantee the shortest path
- Deep recursion may cause stack overflow
- Traversal order depends heavily on graph structure

---

# Screenshots

## Graph Structure Output

![Graph Structure](![Graph Structure.png](docs/screenshots/Graph%20Structure.png))

---

## BFS Traversal Output

![BFS Traversal](![BFS Traversal1.png](docs/screenshots/BFS%20Traversal1.png)![BFS Traversal2.png](docs/screenshots/BFS%20Traversal2.png)![BFS Traversal3.png](docs/screenshots/BFS%20Traversal3.png))

---

## DFS Traversal Output

![DFS Traversal](![DFS Traversal1.png](docs/screenshots/DFS%20Traversal1.png)![DFS Traversal2.png](docs/screenshots/DFS%20Traversal2.png)![DFS Traversal3.png](docs/screenshots/DFS%20Traversal3.png))

---

## Performance Results

![Performance Results](![Performance Results.png](docs/screenshots/Performance%20Results.png))

---

# Reflection

This assignment helped me understand graph traversal algorithms and graph representation using adjacency lists.

I learned how Breadth-First Search and Depth-First Search work internally and how graph structure affects traversal order. I also learned how to measure algorithm performance using `System.nanoTime()` and compare algorithm efficiency.

One challenge during implementation was correctly managing visited vertices to avoid infinite loops. Another challenge was implementing recursive DFS correctly. Overall, the assignment improved my understanding of graph data structures and traversal techniques.

---

# Conclusion

This project successfully implemented BFS and DFS traversal algorithms using Java.

The adjacency list representation provided an efficient way to store graphs, and experimental analysis showed that both traversal algorithms follow the expected time complexity of:

```text
O(V + E)
```

The project demonstrated the practical differences between BFS and DFS and their applications in graph-related problems.