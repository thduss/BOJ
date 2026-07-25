import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;

        // 위치 찾기
        int lx = 0, ly = 0;
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='L'){
                    lx = i;
                    ly = j;
                } else if(maps[i].charAt(j)=='E'){
                    ex = i;
                    ey = j;
                } else if(maps[i].charAt(j)=='S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        int labber = bfs(sx, sy, lx, ly, maps);
        int exit = bfs(lx, ly, ex, ey, maps);
        // System.out.println(labber + " " + exit);
        if(labber==-1 || exit==-1) return -1;
        
        return labber + exit;
    }
    
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    
    public static int bfs(int sx, int sy, int ex, int ey, String[] maps){
        int N = maps.length, M = maps[0].length();
        int answer = -1;
        
        boolean[][] visited = new boolean[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==ex && cur[1]==ey){
                answer = cur[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || maps[nx].charAt(ny)=='X') continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2]+1});
            }
        }
        
        return answer;
    }
}