import java.util.*;

class Solution {
    List<List<Integer>> graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        for(int[] w : wires){
            graph.get(w[0]).remove(Integer.valueOf(w[1]));
            graph.get(w[1]).remove(Integer.valueOf(w[0]));
            
            int a = find(w[0], n);
            int b = find(w[1], n);
            
            answer = Math.min(answer, Math.abs(a-b));
            
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        return answer;
    }
    
    public int find(int start, int N){
        int cnt=0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            
            for(int nxt : graph.get(cur)){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
        
        return cnt;
    }
}