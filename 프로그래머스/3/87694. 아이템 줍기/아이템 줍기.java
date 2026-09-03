import java.util.*;

class Solution {
    public int map[][];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        map = new int[101][101];
        for(int[] rect : rectangle){
            int x = rect[0]*2;
            int y = rect[1]*2;
            
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            for(int i=x; i<=x2; i++){
                for(int j=y; j<=y2; j++){
                    if(i==x || j==y || i==x2 || j==y2){
                        if(map[i][j]==2){
                            continue;
                        } 
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    public int[] dx = {0,0,-1,1};
    public int[] dy = {-1,1,0,0};
    
    public int bfs(int sx, int sy, int itemX, int itemY){
        boolean[][] visited = new boolean[101][101];
        int cnt=0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==itemX && cur[1]==itemY){
                cnt = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>100 || ny<0 || ny>100) continue;
                if(map[nx][ny]!=1) continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2]+1});
            }
        }
        
        return cnt/2;
    }
}