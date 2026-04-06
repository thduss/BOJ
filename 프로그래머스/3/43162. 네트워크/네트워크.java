import java.util.*;

class Solution {
    
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public static void bfs(int s, int n, int[][] computers){
        
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            visited[cur] = true;
            
            for(int i=0; i<n; i++){
                if(computers[cur][i]==1 && !visited[i]){
                    que.add(i);
                }
            }
        }
    }
}