import java.io.*;
import java.util.*;

public class SolutionBFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StandarBFS.Graph graph = new StandarBFS.Graph(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                graph.addEdge(u, v);
            }
            int s = Integer.parseInt(br.readLine()) - 1;
            graph.shortestReach(s);
        }




    }

    private static List<Integer> shortestReach(int n, int[][] edges, int s) {

        List adjList[] = new LinkedList[n];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList();
            adjList[i].add(0, edges);

        }


        return new ArrayList<>();


    }
}