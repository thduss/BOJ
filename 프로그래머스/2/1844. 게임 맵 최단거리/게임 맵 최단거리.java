import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] c = queue.poll();
            
            if(c[0]==N-1 && c[1]==M-1){
                return c[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(maps[nx][ny]==0) continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, c[2]+1});
            }
        }
        
        
        return answer;
    }
}