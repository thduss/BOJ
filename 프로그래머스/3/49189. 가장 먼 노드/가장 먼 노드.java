import java.util.*;

class Solution {
    public List<List<Integer>> graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist = dijkstra(1, n);
        
        int max = 0;
        for(int i=1; i<dist.length; i++){
            if(max<dist[i]){
                max = dist[i];
                answer = 1; 
            } else if(max==dist[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int nxt : graph.get(cur)){
                if(dist[nxt] > dist[cur] + 1){
                    dist[nxt] = dist[cur] + 1;
                    queue.add(nxt);
                }
            }
        }
        
        return dist;
    }
}