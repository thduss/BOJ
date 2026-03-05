import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : costs){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }
        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[] {0,0});
        
        int total = 0, cnt=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(visited[cur[0]]) continue;
            
            visited[cur[0]] = true;
            total+=cur[1];
            cnt++;
            
            if(cnt==n) break;
            
            for(int[] next : graph.get(cur[0])){
                int nNode = next[0];
                int nCost = next[1];
                
                if(!visited[nNode]){
                    pq.add(new int[]{nNode, nCost});
                }
            }
            
        }
        
        answer = total;
        return answer;
    }
    
    
}