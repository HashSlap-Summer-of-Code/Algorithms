// BFS Implementation
import java.util.*;

public class bfs {

    // Function to perform BFS on the graph with dynamic state printing
    public static void breadthFirstSearch(int start, Map<Integer, List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> traversalOrder = new ArrayList<>();

        // Add the starting node to the queue and mark as visited
        queue.add(start);
        visited.add(start);
        printState(visited, queue, traversalOrder, "Initial state:");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            traversalOrder.add(node);

            // Add all unvisited neighbors to the queue
            if (adjacencyList.containsKey(node)) {
                for (int neighbor : adjacencyList.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            // Print state after processing the current node
            printState(visited, queue, traversalOrder, "After processing node " + node + ":");
        }

        // Print the traversal order
        System.out.println("BFS Traversal Order: " + traversalOrder);
    }

    // Helper function to print the state of data structures
    private static void printState(Set<Integer> visited, Queue<Integer> queue, List<Integer> traversalOrder, String message) {
        System.out.println(message);
        System.out.println("Visited: " + visited);
        System.out.println("Queue: " + queue);
        System.out.println("Traversal Order: " + traversalOrder);
        System.out.println();
    }

    // Visualization function for the default example input graph
    public static void currentExampleVisualizeGraphStructured() {
        // This method provides a visualization for a default example input graph.
        // It is intended only to help users understand how the graph looks for this specific case.
        // If the graph structure changes, this visualization must be updated or replaced.
        System.out.println("Visualization for the default example input graph:");
        System.out.println("Node0 -> Node1 -> Node2");
        System.out.println("         |");
        System.out.println("         v");
        System.out.println("      Node3 -> Node5");
        System.out.println("         |");
        System.out.println("         v");
        System.out.println("       Node4");
        System.out.println();
    }

    public static void main(String[] args) {
        // Graph represented as an adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        adjacencyList.put(0, Arrays.asList(1));
        adjacencyList.put(1, Arrays.asList(2, 3));
        adjacencyList.put(2, Collections.emptyList());
        adjacencyList.put(3, Arrays.asList(4, 5));
        adjacencyList.put(4, Collections.emptyList());
        adjacencyList.put(5, Collections.emptyList());

        // Visualize the graph in the structured format for default input graph structure.
        currentExampleVisualizeGraphStructured();

        // Perform BFS starting from node 0
        breadthFirstSearch(0, adjacencyList);
    }
}
