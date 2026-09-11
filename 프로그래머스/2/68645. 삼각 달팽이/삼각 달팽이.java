import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int[][] map = new int[n][n];
        
        int num=1;
        int r=-1, c=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0) r++;
                else if(i%3==1) c++;
                else {
                    r--;
                    c--;
                }
                map[r][c] = num++;
            }
        }
        
        answer = new int[num-1];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}