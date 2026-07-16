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
        
        for(int[] r : results){
            graph.get(r[0]).add(r[1]);
            reverse.get(r[1]).add(r[0]);
        }
        
        for(int i=1; i<=n; i++){
            int pre = count(i, n, graph);
            int post = count(i, n, reverse);
            
            if(pre+post+1 == n){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int count(int i, int n, ArrayList<ArrayList<Integer>> graph){
        int count = 0;
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        return count-1;
        
    }
}