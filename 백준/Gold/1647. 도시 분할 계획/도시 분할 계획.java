import java.util.*;
import java.io.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int v, w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new List[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        boolean[] visited = new boolean[N+1];

        int totalCost=0;
        int maxCost=0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.v]) continue;

            totalCost+=cur.w;
            maxCost = Math.max(maxCost, cur.w);
            visited[cur.v]=true;

            for(Node next : graph[cur.v]){
                if(visited[next.v]) continue;
                pq.add(next);
            }
        }

        System.out.println(totalCost-maxCost);

    }
}
