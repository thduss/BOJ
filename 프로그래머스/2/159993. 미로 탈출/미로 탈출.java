import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int sx=0, sy=0, ex=0, ey=0, lx=0, ly=0;
        int N = maps.length;
        int M = maps[0].length();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maps[i].charAt(j)=='S') {
                    sx = i;
                    sy = j;
                }  
                
                if(maps[i].charAt(j)=='E') {
                    ex = i;
                    ey = j;
                }  
                
                if(maps[i].charAt(j)=='L') {
                    lx = i;
                    ly = j;
                }  
            }
        }
        
        int d1 = bfs(sx, sy, lx, ly, N, M, maps);
        int d2 = bfs(lx, ly, ex, ey, N, M, maps);
        
        if(d1==-1 || d2==-1) return -1;
        answer = d1 + d2;
        
        return answer;
    }
    
    public int bfs(int sx, int sy, int ex, int ey, int N, int M, String[] maps){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});
        
        boolean[][] visited = new boolean[N][M];
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==ex && cur[1]==ey){
                return cur[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx].charAt(ny)=='X') continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2]+1});
            }
        }
        
        return -1;
    }
}