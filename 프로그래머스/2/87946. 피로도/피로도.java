/*
- 최소 필요 피로도/ 소모 피로도
- 탐험할 수 있는 최대 던전 수
*/
import java.util.*;

class Solution {
    boolean[] visited;
    int[][] dungeons;
    int maxCnt=0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        dfs(k, 0);
        answer = maxCnt;
        
        return answer;
    }
    
    public void dfs(int k, int cnt){
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            if(dungeons[i][0]>k) continue;
            
            visited[i] = true;
            dfs(k-dungeons[i][1], cnt+1);
            visited[i] = false;
        }
    }
}