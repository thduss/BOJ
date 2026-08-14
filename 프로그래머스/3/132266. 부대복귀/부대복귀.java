// 최단시간 부대 복귀

import java.util.*;

class Solution {
    public List<List<Integer>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        int[] d = bfs(destination, n);
        
        for(int i=0; i<sources.length; i++){
            answer[i] = d[sources[i]];
        }
        
        return answer;
    }
    
    public int[] bfs(int s, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[s] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int nxt : graph.get(cur)){
                if(dist[nxt]==-1){
                    dist[nxt] = dist[cur] + 1;
                    queue.add(nxt);
                }
            }
        }
        
        return dist;
    }
}