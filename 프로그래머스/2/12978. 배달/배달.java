import java.util.*;

class Solution {
    
    public ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    
    public static class Node{
        int v, w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    
    public static class Vertex implements Comparable<Vertex>{
        int n, total;
        
        public Vertex(int n, int total){
            this.n = n;
            this.total = total;
        }
        
        @Override
        public int compareTo(Vertex o){
            return this.total - o.total;
        }
    }
    
    public int[] dijkstra(int start, int N){
        int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));
        
        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            
            if(visited[cur.n]) continue;
            visited[cur.n] = true;
            
            for(Node e : adj.get(cur.n)){
                if(visited[e.v]) continue;
                
                int nd = cur.total + e.w;
                
                if(dist[e.v]>nd){
                    dist[e.v] = nd;
                    pq.add(new Vertex(e.v, nd));
                }
            }
        }
        return dist;
    }
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : road){
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            
            adj.get(a).add(new Node(b,w));
            adj.get(b).add(new Node(a,w));
        }
        int[] d = dijkstra(1, N);
        
        for(int i=1; i<=N; i++){
            if(d[i]<=K){
                answer++;
            }
        }
        return answer;
    }
}