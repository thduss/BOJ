import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = bfs(n, computers);
        
        return answer;
    }

    public int bfs(int n, int[][] computers){
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                
                while(!que.isEmpty()){
                    int cur = que.poll();
                    visited[cur] = true;

                    for(int j=0; j<n; j++){
                        if(computers[cur][j]==1){
                            if(!visited[j]) que.add(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}