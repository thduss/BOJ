import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    static class Edge {
        int from, to, w;
        Edge(int f, int t, int w) { this.from = f; this.to = t; this.w = w; }
    }

    static class Node implements Comparable<Node> {
        int v, d;
        Node(int v, int d) { this.v = v; this.d = d; }
        public int compareTo(Node o) { return Integer.compare(this.d, o.d); }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        List<Edge> edges = new ArrayList<>(E);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            edges.add(new Edge(a, b, c));
        }

        int answer = INF;

        for (int s = 1; s <= V; s++) {
            int[] dist = dijkstra(s, V, graph);

            for (Edge e : edges) {
                if (e.to == s && dist[e.from] != INF) {
                    answer = Math.min(answer, dist[e.from] + e.w);
                }
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }

    static int[] dijkstra(int start, int V, List<Node>[] graph) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d > dist[cur.v]) continue;

            for (Node nx : graph[cur.v]) {
                int nd = cur.d + nx.d;
                if (nd < dist[nx.v]) {
                    dist[nx.v] = nd;
                    pq.add(new Node(nx.v, nd));
                }
            }
        }
        return dist;
    }
}
