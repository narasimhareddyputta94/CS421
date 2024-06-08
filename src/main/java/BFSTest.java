import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class BFSTest {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java BFSTest");
            System.exit(1);
        }

        String filename = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            boolean[][] graph = new boolean[n][n];

            for (int i = 0; i < m; i++) {
                String[] edge = reader.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                graph[u][v] = true;
            }

            System.out.println("Narasimha Reddy");

            BFS(graph);

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void BFS(boolean[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        queue.add(-1);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == -1) {
                System.out.print("| ");
                if (!queue.isEmpty()) {
                    queue.add(-1);
                }
            } else {
                if (!visited[u]) {
                    System.out.print(u + " ");
                    visited[u] = true;

                    for (int v = 0; v < n; v++) {
                        if (graph[u][v] && !visited[v]) {
                            queue.add(v);
                        }
                    }
                    queue.add(-1);
                }
            }
        }
    }
}
