import java.util.*;

class Solution {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        answer = bfs(maps);    
        
        return answer;
    }
    
    
    public static class Dir{
        int x, y, len;
        
        public Dir(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    public static int bfs(int[][] maps) {
        Queue<Dir> que = new LinkedList<>();
        que.add(new Dir(0,0,1));
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            Dir cur = que.poll();
            
            if(cur.x==maps.length-1 && cur.y==maps[0].length-1){
                return cur.len;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]!= 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.add(new Dir(nx,ny,cur.len+1));
                }
            }
        }
        
        return -1;
    }
}