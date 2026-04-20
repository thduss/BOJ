import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
           
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();   
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        
        for(int i=0; i<results.length; i++){
            int u = results[i][1];
            int v = results[i][0];
            
            graph.get(u).add(v);
            reverse.get(v).add(u);
        }
            
        for(int i=1; i<=n; i++){
            int income = find(i, graph);
            int outcome = find(i, reverse); 
            
            if((income + outcome + 1)==n){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int find(int n, ArrayList<ArrayList<Integer>> graph){
        int cnt = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()+1];
        visited[n] = true;
        
        for(int i : graph.get(n)){
            queue.add(i);
            visited[i] = true;
        }
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            cnt++;
            
            for(int i : graph.get(u)){
                if(!visited[i]){
                    visited[i] = true;
                     queue.add(i);
                }         
            }
        }
        
        return cnt;
    }
}