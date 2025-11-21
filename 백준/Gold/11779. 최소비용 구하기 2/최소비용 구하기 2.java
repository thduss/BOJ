import java.util.*;
import java.io.*;

public class Main {

    static List<Node>[] graph;
    static int N, M;
    static int[] route;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = dijkstra(start, end);

        StringBuilder out = new StringBuilder();
        out.append(ans).append("\n");
        out.append(route.length).append("\n");
        for (int num : route)
            out.append(num).append(" ");

        System.out.println(out.toString());
    }

    static public class Node implements Comparable<Node> {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static private int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist[cur.v])
                continue;
            if (cur.v == end)
                break;

            for (Node next : graph[cur.v]) {
                int nextCost = next.w + cur.w;

                if (dist[next.v] > nextCost) {
                    dist[next.v] = nextCost;
                    parent[next.v] = cur.v;
                    pq.add(new Node(next.v, nextCost));
                }
            }
        }

        int idx = end;
        List<Integer> list = new ArrayList<>();
        while (idx != -1) {
            list.add(idx);
            idx = parent[idx];
        }

        Collections.reverse(list);

        route = new int[list.size()];
        for (int i = 0; i < route.length; i++)
            route[i] = list.get(i);

        return dist[end];
    }
}
