import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = new int[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 1;
        
        int maxDist = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next]==0){
                    dist[next] = dist[cur]+1;
                    queue.add(next);
                    maxDist = Math.max(maxDist, dist[next]);
                }
            }
        }
        
        for(int d : dist){
            if(d==maxDist)
                answer++;
        }
        
        return answer;
    }
}