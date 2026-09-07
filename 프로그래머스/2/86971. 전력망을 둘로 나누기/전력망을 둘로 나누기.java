import java.util.*;

class Solution {
    List<List<Integer>> graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        for(int[] w : wires){
            graph.get(w[0]).remove(Integer.valueOf(w[1]));
            graph.get(w[1]).remove(Integer.valueOf(w[0]));
            
            int diff = find(n);
            answer = Math.min(answer, diff);
            
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        
        return answer;
    }
    
    public int find(int n){
        boolean[] visited = new boolean[n+1];
        List<Integer> set = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            
            int cnt = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = true;
            
            while(!queue.isEmpty()){
                int cur = queue.poll();
                cnt++;
                
                for(int nxt : graph.get(cur)){
                    if(!visited[nxt]) {
                        queue.add(nxt);
                        visited[nxt]=true;
                    }
                }
            }
            
            set.add(cnt);
        }
        
        if(set.size()==2){
            int a = set.get(0);
            int b = set.get(1);
            
            return Math.abs(a-b);
        }
        
        return n;
    }
}