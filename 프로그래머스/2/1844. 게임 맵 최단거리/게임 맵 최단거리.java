import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==N-1 && cur[1]==M-1){
                return cur[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
                if(maps[nx][ny]==0) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2]+1});
            }
        }
        
        return answer;
    }
}