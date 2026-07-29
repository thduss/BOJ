import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 시계방향
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        int num = 1;
        int[][] map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = num++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            int xdist = Math.abs(q[0] - q[2]);
            int ydist = Math.abs(q[1] - q[3]);
            
            int x = q[0], y = q[1];
            int minValue = map[x][y];
            int next = map[x][y];
            for(int j=0; j<4; j++){
                if(j%2==1){
                    // 다음 x 찾기
                    for(int k = 0; k<xdist; k++){
                        x = x + dx[j];
                        y = y + dy[j];
                        if(x>rows || y>columns || x<0 || y<0) continue;  
                        int tmp = map[x][y];
                        map[x][y] = next;
                        next = tmp;
                        
                        minValue = Math.min(minValue, map[x][y]);
                    }
                    
                } else {
                    // 다음 y 찾기
                    for(int k = 0; k<ydist; k++){
                        x = x + dx[j];
                        y = y + dy[j];
                        
                        if(x>rows || y>columns || x<0 || y<0) continue;
                        int tmp = map[x][y];
                        map[x][y] = next;
                        next = tmp;
                        
                        minValue = Math.min(minValue, map[x][y]);
                        
                    }
                }
            }
            
            answer[i] = minValue;
        }
        
        return answer;
    }
}