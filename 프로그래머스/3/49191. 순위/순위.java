import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverse = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        
        for(int[] r : results){
            graph.get(r[0]).add(r[1]);
            reverse.get(r[1]).add(r[0]);
        }
        
        for(int i=1; i<=n; i++){
            int c1 = countNode(i, graph, n);
            int c2 = countNode(i, reverse, n);
            
            if(c1+c2==n+1){
                answer++;
            }
        }
            
        return answer;
    }
    
    public int countNode(int start, List<List<Integer>> graph, int N){
        int cnt = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        
        queue.add(start);
        visited[start]=true;
        
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