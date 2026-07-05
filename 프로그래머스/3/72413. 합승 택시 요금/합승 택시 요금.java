import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 20000000;
        int answer = INF;
        
        // 초기화
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        // i -> k -> j
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        
        // (s -> k) + (k -> a) + (k -> b)
        for(int k=1; k<=n; k++){
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        
        return answer;
    }
}