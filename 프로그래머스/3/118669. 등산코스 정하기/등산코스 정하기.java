import java.util.*;

class Solution {
    List<List<Node>> graph;
    
    public class Node implements Comparable<Node> {
        int u, w;
        
        Node(int u, int w){
            this.u = u;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    boolean[] isTop;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        isTop = new boolean[n+1];
        for(int s : summits) isTop[s] = true;
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] p : paths){
            graph.get(p[0]).add(new Node(p[1], p[2]));
            graph.get(p[1]).add(new Node(p[0], p[2]));
        }
        
        int[] dist = dijkstra(gates, n);
        Arrays.sort(summits);      
        for(int s : summits){
            if(dist[s]!=Integer.MAX_VALUE && answer[1]>dist[s]){
                answer[0] = s;
                answer[1] = dist[s];
            } 
        }
        
        return answer;
    }
    
    public int[] dijkstra(int[] gates, int N){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int g : gates){
            dist[g] = 0;
            queue.add(new Node(g, 0));
        }
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(dist[cur.u]<cur.w) continue;
            if(isTop[cur.u]) continue;
            
            for(Node nxt : graph.get(cur.u)){
                int maxIn = Math.max(cur.w, nxt.w);
                if(dist[nxt.u]>maxIn){
                    dist[nxt.u] = maxIn;
                    queue.add(new Node(nxt.u, maxIn));
                }
            }
        }
        
        return dist;
    }
}