import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjacencyList;

    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {

        Vertex source = vertices.get(from);
        Vertex destination = vertices.get(to);

        Edge edge = new Edge(source, destination, weight);

        adjacencyList.get(from).add(edge);

    }

    public void printGraph() {

        System.out.println("Weighted Graph Structure:");

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (Edge edge : adjacencyList.get(vertex)) {

                System.out.print(
                        edge.getDestination().getId() +
                                "(w:" + edge.getWeight() + ") "
                );
            }

            System.out.println();
        }
    }

    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination().getId();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(start, visited);

        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {

            int neighbor = edge.getDestination().getId();

            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {

        int size = vertices.size();

        int[] distance = new int[size];

        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {

            int current = getMinDistanceVertex(distance, visited);

            visited[current] = true;

            for (Edge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination().getId();

                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distance[current] != Integer.MAX_VALUE
                        && distance[current] + weight < distance[neighbor]) {

                    distance[neighbor] =
                            distance[current] + weight;
                }
            }
        }

        printDijkstraResults(start, distance);
    }

    private int getMinDistanceVertex(int[] distance, boolean[] visited) {

        int min = Integer.MAX_VALUE;

        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {

            if (!visited[i] && distance[i] < min) {

                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printDijkstraResults(int start, int[] distance) {

        System.out.println("\nDijkstra Shortest Paths from Vertex " + start);

        for (int i = 0; i < distance.length; i++) {

            System.out.println("To Vertex " + i + " = " + distance[i]);
        }
    }
}