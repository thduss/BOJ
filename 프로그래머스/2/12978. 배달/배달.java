import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] arr : road){
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }
        
        answer = dikstra(N, K, road);

        return answer;
    }
    
    public static class Node implements Comparable<Node>{
        int v, w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public static int dikstra(int N, int K, int[][] road){
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.v;
            int curCost = curNode.w;
    
            // 가지치기
            if(curCost>dist[cur]) continue;
            
            for(Node next : graph.get(cur)){
                if(dist[next.v]>dist[cur]+next.w){
                    dist[next.v] = dist[cur]+next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        int cnt=0;
        for(int d : dist){
            if(d<=K){
                cnt++;
            }
        }
        
        return cnt;
    }
}