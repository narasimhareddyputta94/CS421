// DFSTest.java

// Narasimha Reddy Putta

import java.io.*;
import java.util.*;

public class DFSTest {

    static int n; // Number of vertices
    static int[][] adjacencyMatrix;
    static boolean[] visited;
    static List<Integer> previsitQueue = new ArrayList<>();
    static List<Integer> postvisitQueue = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DFSTest <input_file>");
            System.exit(1);
        }

        String fileName = args[0];
        readGraph(fileName);
        visited = new boolean[n];

        // Start DFS from vertex 1
        DFS(1);

        // Print results
        System.out.println("Narasimha Reddy Putta");
        System.out.print("Previsit queue: ");
        for (int v : previsitQueue) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.print("Postvisit queue: ");
        for (int v : postvisitQueue) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void readGraph(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            return;
        }

        try {
            n = Integer.parseInt(reader.readLine().trim());
            int m = Integer.parseInt(reader.readLine().trim());

            adjacencyMatrix = new int[n][n];

            for (int i = 0; i < m; i++) {
                String[] edge = reader.readLine().trim().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                adjacencyMatrix[u][v] = 1;
                adjacencyMatrix[v][u] = 1; // because the graph is undirected
            }
            reader.close();
        } catch (IOException e) {
        }
    }

    static void DFS(int v) {
        visited[v] = true;
        previsitQueue.add(v);
        for (int w = 0; w < n; w++) {
            if (adjacencyMatrix[v][w] == 1 && !visited[w]) {
                DFS(w);
            }
        }
        postvisitQueue.add(v);
    }
}
