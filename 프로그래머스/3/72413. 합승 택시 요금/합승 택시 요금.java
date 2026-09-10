import java.util.*;

class Solution {
    public class Node implements Comparable<Node> {
        int v, w;
        
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public List<List<Node>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] f : fares){
            graph.get(f[0]).add(new Node(f[1], f[2]));
            graph.get(f[1]).add(new Node(f[0], f[2]));
        }
        
        int[] fromS = dijkstra(s, n);
        int[] fromA = dijkstra(a, n);
        int[] fromB = dijkstra(b, n);
        
        for(int i=1; i<=n; i++){
            if(fromS[i]==Integer.MAX_VALUE || fromA[i]==Integer.MAX_VALUE || fromB[i]==Integer.MAX_VALUE) continue;
            answer = Math.min(answer, fromS[i] + fromB[i] + fromA[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int s, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(Node nxt : graph.get(cur)){
                if(dist[nxt.v]>dist[cur]+nxt.w){
                    dist[nxt.v] = dist[cur] + nxt.w;
                    queue.add(nxt.v);
                }
            }
        }
        
        return dist;
    }
}