import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int[] r : results){
            win.get(r[0]).add(r[1]);
            lose.get(r[1]).add(r[0]);
        }
        
        for(int i=1; i<=n; i++){
            int wcnt = find(i, n, win);
            int lcnt = find(i, n, lose);
            
            if(wcnt+lcnt==n-1) answer++;
        }
        
        return answer;
    }
    
    public int find(int node, int N, List<List<Integer>> graph){
        int cnt=0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        queue.add(node);
        visited[node] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            if(!visited[cur]) cnt++;
            visited[cur] = true;
            
            for(int nxt : graph.get(cur)){
                if(!visited[nxt]) queue.add(nxt);
            }
        }
        
        return cnt;
    }
}