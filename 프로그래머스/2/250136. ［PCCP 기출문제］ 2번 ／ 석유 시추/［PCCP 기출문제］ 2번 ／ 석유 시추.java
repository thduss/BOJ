import java.util.*;

class Solution {
    
    public boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        Map<Integer, Integer> oilSize = new HashMap<>();
        
        int s = 2;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j]==1){
                    int size = bfs(i, j, s, land);
                    oilSize.put(s, size);
                    s++;
                }
            }
        }
        
        for(int i=0; i<land[0].length; i++){
            Set<Integer> set = new HashSet<>();
            
            for(int j=0; j<land.length; j++){
                if(land[j][i]!=0) set.add(land[j][i]);
            }
            
            int cnt=0;
            for(int n : set){
                cnt += oilSize.get(n);
            }
            
            answer = Math.max(answer, cnt);
        }
        
        
        return answer;
    }
    
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    
    public int bfs(int x, int y, int mark, int[][] land){
        int cnt = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            cnt++;
            
            land[cur[0]][cur[1]] = mark;
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || ny<0 || nx>=land.length || ny>=land[0].length) continue;
                if(land[nx][ny]!=1) continue;
                
                land[nx][ny] = mark;
                queue.add(new int[]{nx, ny});         
            }
        }
        
        return cnt;
    }
}