import java.util.*;

class Solution {
    
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};
    
    public int solution(String[] board) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R'){
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(board[cur[0]].charAt(cur[1])=='G'){
                return cur[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0], ny = cur[1];
                
                while(nx>=0 && ny>=0 && nx<board.length && ny<board[0].length() && board[nx].charAt(ny)!='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        
        return -1;
    }
}