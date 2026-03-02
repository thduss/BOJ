import java.util.*;

class Solution {
    public static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new LinkedList<>();
        
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                if(maps[i].charAt(j)!='X'&&!visited[i][j]){
                    int days = dfs(i,j,maps);
                    list.add(days);
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        
        Collections.sort(list);
        answer = new int[list.size()];
        int idx=0;
        for(int day : list){
            answer[idx++] = day;
        }
        
        return answer;
    }
    
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {-1,1,0,0};
    
    private static int dfs(int i, int j, String[] maps){
        int sum = maps[i].charAt(j) - '0';
        visited[i][j] = true;
        
        for(int idx=0; idx<4; idx++){
            int nx = dx[idx] + i;
            int ny = dy[idx] + j;
            
            if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length()) continue;
            if(visited[nx][ny] || maps[nx].charAt(ny)=='X') continue;
            
            sum += dfs(nx,ny,maps);
        }
        
        return sum;
    }
}