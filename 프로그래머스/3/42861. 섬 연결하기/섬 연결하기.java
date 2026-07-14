import java.util.*;

class Solution {
    
    public class Node implements Comparable<Node>{
        int v, c;
        
        public Node(int v, int c){
            this.v = v;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o){
            return this.c - o.c;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] cost : costs){
            graph.get(cost[0]).add(new Node(cost[1], cost[2]));
            graph.get(cost[1]).add(new Node(cost[0], cost[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        boolean[] visited = new boolean[n];
        int count = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(visited[cur.v]) continue;
            visited[cur.v] = true;
            count++;
            answer+=cur.c;
            
            if(count==n) break;
            
            for(Node next : graph.get(cur.v)){
                if(visited[next.v]) continue;
                
                pq.add(new Node(next.v, next.c));
            }
            
        }
        
        
        return answer;
    }
}