
import java.util.*;

public class DSA9 {
    int vertices;
    int[][] adjMatrix;

    DSA9(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    // Add directed edge
    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
    }

    // Breadth First Search (BFS)
    void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    // Depth First Search (DFS)
    void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int v = sc.nextInt();

        DSA9 g = new DSA9(v);

        System.out.print("Enter number of one-way roads: ");
        int e = sc.nextInt();

        System.out.println("Enter source and destination of each road:");

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        System.out.print("Enter starting city (0 to " + (v - 1) + "): ");
        int start = sc.nextInt();

        g.BFS(start);
        g.DFS(start);

        sc.close();
    }
}
