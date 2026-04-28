import java.util.*;

class Solution {
    
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] maps) {
        int answer = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            
            int[] cur = queue.poll();
            if(cur[0]==maps.length-1 && cur[1]==maps[0].length-1){
                answer = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length) continue;
                if(visited[nx][ny] || maps[nx][ny]==0) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2]+1});
            }
            
        }
        
        return answer;
    }
}