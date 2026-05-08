import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                queue.add(i);
                visited[i] = true;
            }
            
            while(!queue.isEmpty()){
                int cur = queue.poll();
                
                for(int j=0; j<n; j++){
                    if(!visited[j] && computers[cur][j]==1){
                        visited[j] = true;
                        queue.add(j);
                    }
                    
                }
            }
        }
        
        return answer;
    }
}