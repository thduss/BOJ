import java.util.*;

class Solution {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        answer = bfs(0,0, maps);
        
        return answer;
    }
    
    public static int bfs(int x, int y, int[][] maps){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==maps.length-1 && cur[1]==maps[0].length-1){
                return cur[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = dx[i]+cur[0];
                int ny = dy[i]+cur[1];
                int cnt=cur[2];

                if(nx>=visited.length || nx<0 || ny>=visited[0].length || ny<0) continue;

                if(maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny,cnt+1});
                }
            }
            
        }   
        
        return -1;
    }
}