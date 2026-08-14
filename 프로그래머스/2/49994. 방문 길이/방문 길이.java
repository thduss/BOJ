// -5 ~ 5 넘어가는 명령어 무시
// 처음 걸어본 길의 길이

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] visited = new int[11][11];
        
        int x = 5, y = 5;
        for(int i=0; i<dirs.length(); i++){
            char cmd = dirs.charAt(i);
            
            if(cmd=='U'){
                if(x==10) continue;
                
                // 양쪽 비트마스킹
                if((visited[x][y] & (1<<1)) == 0) {
                    visited[x][y] = visited[x][y] | (1<<1);
                    x++;
                    answer++;
                    visited[x][y] = visited[x][y] | (1<<2);
                } else {
                    x++;
                }
            } else if (cmd=='D'){
                if(x==0) continue;
                
                if((visited[x][y] & (1<<2)) == 0) {
                    visited[x][y] = visited[x][y] | (1<<2);
                    answer++;
                    x--;
                    visited[x][y] |= (1<<1);
                } else {
                    x--;
                }
            } else if (cmd=='R'){
                if(y==10) continue;
                
                if((visited[x][y] & (1<<3)) == 0) {
                    visited[x][y] = visited[x][y] | (1<<3);
                    answer++;
                    y++;
                    visited[x][y] |= (1<<4);
                } else {
                    y++;
                }
            } else {
                if(y==0) continue;
                
                if((visited[x][y] & (1<<4)) == 0) {
                    visited[x][y] = visited[x][y] | (1<<4);
                    answer++;
                    y--;
                    visited[x][y] |= (1<<3);
                } else {
                    y--;
                }
            }
        }
        
        return answer;
    }
}