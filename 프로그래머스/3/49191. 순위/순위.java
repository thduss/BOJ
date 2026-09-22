import java.util.*;

class Solution {
    List<List<Integer>> graph;
    List<List<Integer>> reverse;
    
    public int solution(int n, int[][] results) {
        int answer = 0;

        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        
        for(int[] r : results){
            graph.get(r[0]).add(r[1]);
            reverse.get(r[1]).add(r[0]);
        }
        
        for(int i=1; i<=n; i++){
            if(canRank(i, n)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean canRank(int n, int N){
        int lose = find(reverse, n, N);
        int win = find(graph, n, N);
        
        if(lose+win+1==N){
            return true;
        } else {
            return false;
        }
    }
    
    public int find(List<List<Integer>> g, int start, int N){
        int cnt = 0;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int nxt : g.get(cur)){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    cnt++;
                    queue.add(nxt);
                }
            }
        }
        
        return cnt;
    }
}