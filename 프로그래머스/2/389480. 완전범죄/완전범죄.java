import java.util.*;

class Solution {
    public int N, M;
    public int minN = Integer.MAX_VALUE;
    public boolean[][][] visited;
    
    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        N = n;
        M = m;
        visited = new boolean[info.length][N][M];
        dfs(0, info, 0, 0);
        answer = minN==Integer.MAX_VALUE ? -1 : minN;
        
        return answer;
    }
    
    public void dfs(int idx, int[][] info, int a, int b){
        if(idx>=info.length){
            if(a<N && b<M){
                minN = Math.min(minN, a);
            }
            return;
        }
        
        if(a>=N || b>=M) return;
        if(visited[idx][a][b]) return;
        visited[idx][a][b] = true;
        
        if(a+info[idx][0]<N) dfs(idx+1, info, a+info[idx][0], b);
        if(b+info[idx][1]<M)  dfs(idx+1, info, a, b+info[idx][1]);
    }
}