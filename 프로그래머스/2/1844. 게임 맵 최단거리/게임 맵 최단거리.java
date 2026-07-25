import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;

        // (0,0) ~ (n-1,m-1) 최단거리
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==n-1 && cur[1]==m-1) {
                answer = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || maps[nx][ny]==0) continue;
                if(visited[nx][ny]) continue; 
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,cur[2]+1});
            }
        }
        
        return answer;
    }
}