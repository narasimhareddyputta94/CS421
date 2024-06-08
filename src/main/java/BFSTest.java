import java.io.*;
import java.util.*;

public class BFSTest {
    private List<Integer>[] graph;

    public BFSTest(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        graph[u].add(v);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(start);
        queue.add(-1);
        visited[start] = true;

        System.out.println("Narasimha Reddy");

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == -1) {
                if (!queue.isEmpty()) {
                    queue.add(-1);
                }
                System.out.print("| ");
            } else {
                System.out.print(u + " ");
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java BFSTest filename");
            return;
        }

        String filename = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            org.example.BFSTest bfsTest = new org.example.BFSTest(n);

            for (int i = 0; i < m; i++) {
                String[] line = br.readLine().trim().split("\\s+");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                bfsTest.addEdge(u, v);
            }

            bfsTest.bfs(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
